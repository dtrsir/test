# CMAKE generated file: DO NOT EDIT!
# Generated by "NMake Makefiles" Generator, CMake Version 3.20

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:

#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:

.SUFFIXES: .hpux_make_needs_suffix_list

# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

#Suppress display of executed commands.
$(VERBOSE).SILENT:

# A target that is always out of date.
cmake_force:
.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

!IF "$(OS)" == "Windows_NT"
NULL=
!ELSE
NULL=nul
!ENDIF
SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\CLion 2021.2.1\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\CLion 2021.2.1\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = D:\sourceCode\cCode\test

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = D:\sourceCode\cCode\test\cmake-build-debug

# Include any dependencies generated for this target.
include CMakeFiles\test.dir\depend.make
# Include the progress variables for this target.
include CMakeFiles\test.dir\progress.make

# Include the compile flags for this target's objects.
include CMakeFiles\test.dir\flags.make

CMakeFiles\test.dir\main.c.obj: CMakeFiles\test.dir\flags.make
CMakeFiles\test.dir\main.c.obj: ..\main.c
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir=D:\sourceCode\cCode\test\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_1) "Building C object CMakeFiles/test.dir/main.c.obj"
	"D:\Visual Studio2019\VC\Tools\MSVC\14.29.30133\bin\Hostx86\x86\cl.exe" @<<
 /nologo $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) /FoCMakeFiles\test.dir\main.c.obj /FdCMakeFiles\test.dir\ /FS -c D:\sourceCode\cCode\test\main.c
<<

CMakeFiles\test.dir\main.c.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing C source to CMakeFiles/test.dir/main.c.i"
	"D:\Visual Studio2019\VC\Tools\MSVC\14.29.30133\bin\Hostx86\x86\cl.exe" > CMakeFiles\test.dir\main.c.i @<<
 /nologo $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) -E D:\sourceCode\cCode\test\main.c
<<

CMakeFiles\test.dir\main.c.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling C source to assembly CMakeFiles/test.dir/main.c.s"
	"D:\Visual Studio2019\VC\Tools\MSVC\14.29.30133\bin\Hostx86\x86\cl.exe" @<<
 /nologo $(C_DEFINES) $(C_INCLUDES) $(C_FLAGS) /FoNUL /FAs /FaCMakeFiles\test.dir\main.c.s /c D:\sourceCode\cCode\test\main.c
<<

# Object files for target test
test_OBJECTS = \
"CMakeFiles\test.dir\main.c.obj"

# External object files for target test
test_EXTERNAL_OBJECTS =

test.exe: CMakeFiles\test.dir\main.c.obj
test.exe: CMakeFiles\test.dir\build.make
test.exe: CMakeFiles\test.dir\objects1.rsp
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir=D:\sourceCode\cCode\test\cmake-build-debug\CMakeFiles --progress-num=$(CMAKE_PROGRESS_2) "Linking C executable test.exe"
	"D:\CLion 2021.2.1\bin\cmake\win\bin\cmake.exe" -E vs_link_exe --intdir=CMakeFiles\test.dir --rc="D:\Windows Kits\10\bin\10.0.19041.0\x86\rc.exe" --mt="D:\Windows Kits\10\bin\10.0.19041.0\x86\mt.exe" --manifests -- "D:\Visual Studio2019\VC\Tools\MSVC\14.29.30133\bin\Hostx86\x86\link.exe" /nologo @CMakeFiles\test.dir\objects1.rsp @<<
 /out:test.exe /implib:test.lib /pdb:D:\sourceCode\cCode\test\cmake-build-debug\test.pdb /version:0.0 /machine:X86 /debug /INCREMENTAL /subsystem:console  kernel32.lib user32.lib gdi32.lib winspool.lib shell32.lib ole32.lib oleaut32.lib uuid.lib comdlg32.lib advapi32.lib 
<<

# Rule to build all files generated by this target.
CMakeFiles\test.dir\build: test.exe
.PHONY : CMakeFiles\test.dir\build

CMakeFiles\test.dir\clean:
	$(CMAKE_COMMAND) -P CMakeFiles\test.dir\cmake_clean.cmake
.PHONY : CMakeFiles\test.dir\clean

CMakeFiles\test.dir\depend:
	$(CMAKE_COMMAND) -E cmake_depends "NMake Makefiles" D:\sourceCode\cCode\test D:\sourceCode\cCode\test D:\sourceCode\cCode\test\cmake-build-debug D:\sourceCode\cCode\test\cmake-build-debug D:\sourceCode\cCode\test\cmake-build-debug\CMakeFiles\test.dir\DependInfo.cmake --color=$(COLOR)
.PHONY : CMakeFiles\test.dir\depend
