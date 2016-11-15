extern printf
SECTION .data
_printInt db "%d",0
_printFloat db "%f",0
_printLine db 10,0
a 
SECTION .bss
_float: resq 1
SECTION .text
global _WinMain@16
_WinMain@16:
push 5
pop eax
mov [a], eax
push dword [a]
pop eax
fld dword eax
fstp qword [_float]
push dword [_float+4]
push dword [_float]
push dword _printFloat
call printf
add esp, 8
mov eax,0
ret 16
