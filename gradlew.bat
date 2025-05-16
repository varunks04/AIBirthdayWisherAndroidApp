@echo off
rem Gradle wrapper script for Windows

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.

set GRADLE_HOME=%DIRNAME%gradle\wrapper\gradle-wrapper.properties
if not exist "%GRADLE_HOME%" (
    echo "Gradle wrapper properties file not found."
    exit /b 1
)

set WRAPPER_PROPERTIES_FILE=%DIRNAME%gradle\wrapper\gradle-wrapper.properties
for /f "tokens=1,2 delims==" %%A in ('findstr /r "^distributionUrl=" "%WRAPPER_PROPERTIES_FILE%"') do (
    set DISTRIBUTION_URL=%%B
)

if "%DISTRIBUTION_URL%"=="" (
    echo "No distribution URL found in gradle-wrapper.properties."
    exit /b 1
)

set GRADLE_VERSION=%DISTRIBUTION_URL:~34,6%
set GRADLE_VERSION=%GRADLE_VERSION:/=%
set GRADLE_VERSION=%GRADLE_VERSION:.zip=%

echo "Starting Gradle %GRADLE_VERSION%..."

java -jar "%DIRNAME%gradle\wrapper\gradle-wrapper.jar" %*