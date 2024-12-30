<h1>Дипломный проект</h1>
<h2>Запуск автотестов</h2>
<detail><summary>Предусловия:</summary>
    <ul>
        <li>Локально установлен JDK 11.</li>
        <li>JAVA_HOME определена и установленную JAVA 11.</li>
        <li>Установлена Android Studio.</li>
        <li>Установлена стабильная версия Android SDK.</li>
        <li>Физическое устройство с Android 13 и API 33, с установленным системным русским языком.</li>
        <li>Установлен Allure.</li>
    </ul>
</detail>

<ol>
    <li>Склонировать репозиторий с проектом
        <a href="https://github.com/GrigoriyKaygorodtsev/Diploma">GrigoriyKaygorodtsev/Diploma</a>
    </li>
    <li>Открыть репозиторий
        <a href="https://github.com/GrigoriyKaygorodtsev/Diploma/tree/main/fmh_android_15_03_24">fmh_android_15_03_24</a>
    в Android Studio.</li>
    <li>Переопределить JAVA используемую в проекте на JAVA_HOME. По пути "File/Settings/Build, Execution, Deployment/Build Tools/Gradle -> Gradle JDK".</li>
    <li>Скомпилировать проект.</li>
    <li>Запустить физическое устройство на Android 13 или Android эмулятор с API 33.</li>
    <li>Запустить выполнение тестов командной "./gradlew connectedAndroidTest" из терминала AndroidStudio. Либо командой "gradle connectedAndroidTest" из другого терминала, находясь в репозитории "fmh_android_15_03_24".</li>
    <li>По окончании прогона автотестов, выгрузить папку "allure-results". По пути "Device Explorer/sdcard/googletests/test_outputfiles/allure-results"</li>
</ol>