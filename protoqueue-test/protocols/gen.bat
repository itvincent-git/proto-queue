@echo off
cd /d %~dp0

md ./files3
del /q /s ./files3/*.proto
copy /y remote/*.proto ./files3

rem protoc --javanano_out=enum_style=java,optional_field_style=accessors,parcelable_messages=false,java_multiple_files＝true,ignore_services=true:. -I . ./*.proto
rem cd ..
rem set des=%cd%\src\main\java\com
rem echo %des%
rem xcopy /S /Y protocols\com %des%
rem rd /s/q %cd%\protocols\com