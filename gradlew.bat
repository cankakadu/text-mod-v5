@echo off
setlocal
set "VERSION=9.6.1"
if not defined GRADLE_USER_HOME set "GRADLE_USER_HOME=%USERPROFILE%\.gradle"
set "BASE=%GRADLE_USER_HOME%\wrapper\dists\gradle-%VERSION%-bin\texturecustomizer"
set "DIST=%BASE%\gradle-%VERSION%"
if not exist "%DIST%\bin\gradle.bat" (
  if not exist "%BASE%" mkdir "%BASE%"
  echo Downloading Gradle %VERSION%...
  powershell -NoProfile -ExecutionPolicy Bypass -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest 'https://services.gradle.org/distributions/gradle-%VERSION%-bin.zip' -OutFile '%BASE%\gradle.zip'; Expand-Archive -Force '%BASE%\gradle.zip' '%BASE%'"
  if errorlevel 1 exit /b 1
)
call "%DIST%\bin\gradle.bat" %*
exit /b %ERRORLEVEL%
