<h1> План тестирования</h1>

<details><summary>Описание плана</summary>
    <ol>
     <li> <a href="#title0">Описание приложения</a>.</li>
     <li> Определение <a href="#title1">границ приложения</a>.</li>
     <li> Определение <a href="#title2">функционала приложения</a>.</li>
     <li> Определение <a href="#title3">необходимых и возможных видов тестирования</a>.</li>
     <li> Определение <a href="#title4">инстументов и устройств для проведения тестирования</a> .</li>
     <li> Написание <a href="#title5">чек-листа проверок</a>.</li>
     <li> Написание <a href="#title6">тест-кейсов</a> по <a href="#title5"> чек-листу</a>.</li>
     <li> <a href="#title7"> Реализация тест-кейсов</a> ручным тестированием.</li>
     <li> Заведение <a href="#title8">баг-репортов</a> по результатам ручного тестирования.</li>
     <li> Составление <a href="#title9">отчета по результатам ручного тестирования</a>.</li>
     <li> Анализ <a href="#title10">результатов ручного тестирования</a>.</li>
     <li> <a href="#title11"> Подготовка проекта</a> для проведения автоматизированного тестирования.</li>
     <li> <a href="#title12">Реализация автоматизированныз тест-кейсов</a> на основе тест-кейсов ручного тестирования.</li>
     <li> <a href="title13">Сценарий автоматизации</a>.</li>
     <li> Составление <a href="#title14">отчета, по результатам автоматизированного тестирования</a>.</li>
     <li> Анализ <a href="#title15">результатов автоматизированного тестирования</a>.</li> 
    </ol>
</details>

<h2><a id="title0">Описание приложения</a></h2>
   Приложение "V Hospise" даёт функционал по работе с новостями хосписа и включает в себя:
      <ul>
         <li>Информацию о новостях и функционал для работы с ними.</li>
         <li>Тематические цитаты.</li>
         <li>Информацию о приложении.</li>
      </ul>

<h2><a id="title1">Границы приложения</a></h2>
   <details><summary>Составляющие приложения</summary>
      <ul>
         <details><summary>Экран загрузки. (Splash Sreen)</summary>
          <ul>
            <il>Тематическое изображение.</li>
            <li>Анимация загрузки.</li>
            <li>Текстовая цитата.</li>
      </ul>
   </details>
   <details><summary>Страница авторизации.</summary>
      <ul>
        <li>Заголовок с текстом "Авторизация".</li>
        <li>Поле ввода логина.</li>
        <li>Поле ввода пароля.</li>
        <li>Кнопка "ВОЙТИ".</li>
      </ul>
   </details> 
   <details><summary>Верхняя панель. (AppBar)</summary>
     <ul>
       <li>Иконка "бургерного меню", имеющая кнопки перехода к страницам:
          <ul>
             <li>"Главная".</li>
             <li>"Новости".</li>
             <li>"О приложении".</li>
          </ul>
       </li>
       <li>Текстовый заголовок с названием приложения "В Хосписе".</il>
       <li>Иконка бабочка - переход к странице тематических цитат.</li>
       <li>Иконка человек - переход к кнопке "Войти".</il>
    </ul>
   </details>
   <details><summary>Список главного меню</summary>
      <ul>
         <li>AppBar.</li>
         <li>
           <details><summary>Блок списка новостей.</summary>
             <ul>
               <li>Название блока "Новости".</li>
               <li>Иконка "стрелка" скрытия/раскрытия списка.</li>
               <li>Три новости с заголовками и датами публикации.</li>
               <li>Кнопка "Все новости" переход на страницу "Новости".</li>
             </ul>
           </details>
        </li>
     </ul>
   </detais>
   <details><summary>Страница новостей новости.</summary>
      <ul>
         <li>AppBar.</li>
         <li>Заголовок страницы с текстом "Новости".</li>
         <li>Кнопка сортировки новостей (две разнонаправленные стрелки).</li>
         <li>Кнопка фильтра поиска новостей.</li>
         <li>Кнопка редактирования новостей.</li>
         <li>
            <details><summary>Список новостей с короткой информацией</summary>
               <ul>
                  <li>Тематическая иконка новости.</li>
                  <li>Заголовок новости.</li>
                  <li>Иконка раскрытия/скрытия подробной информации новости.</li>
               </ul>
            </details>
         </li>
      </ul>       
   </details>  
   <details><summary>Страница тематических цитат</summary>
      <ul>
         <li>AppBar.</li>
         <li>Заголовок страницы с текстом "Главное - жить любя".</li>
         <li>
            <details><summary>Список цитат.</summary>
               <ul>
                  <li>Тематическая картинка цитат.</li>
                  <li>Заголовок цитаты.</li>
                  <li>Иконка раскрытия/скрытия текста содержания.</li>
                  <li>Текст содержания цитаты.</li>
               </ul>
            </details>
         </li>
      </ul>
   </details>
   <details><summary>Страница "О приложении"</summary>
      <ul>
         <li>AppBar.</li>
         <li>Заголовок страницы "Версия:".</li>
         <li>Текстовое описание "Политика конфиденциальности:" к ссылке на внешний ресурс.</li>
         <li>Текстовое описание "Пользовательское соглашение:" к ссылке на внешний ресурс.</li>
      </ul>
   </details> 
   </ul>
</details>

<h2><a id="title2">Функционал приложения</a></h2>
   <details><summary>Функционал</summary>
      <ul>
         <details><summary>Новости</summary>
            <ul>
               <il>Просмотр новости с главной страницы.</il>
               <il>Просмотр всех новостей на странице "Новости".</il>
               <il>Сортировка новостей на странице "Новости".</il>
               <il>Поиск новостей по фильтру на странице "Новости".</il>
            </ul>
         </details>
         <details><summary>Авторизация</summary>
            <ul>
               <li>Авторизация в приложении.</li>
               <li>Выход из аккаунта.</li>
            </ul>
         </details>
         <details><summary>Тематические цитаты</summary>
            <ul>
               <li>Просмотр тематической цитаты.</li>
            </ul>
         </details>
         <details><summary>Информация о приложении</summary>
            <ul>
               <li>Переход по ссылке "Политика конфиденциальности:".</li>
               <li>Переход по ссылке "Пользовательское соглашение:".</li>
            </ul>
         </details>
      </ul>
   </details>

<h2><a id=title3>Тестирование</a></h2>
   <details><summary>Способы тестирования</summary>
      <ul>
         <details><summary>Тестирование установки</summary>
            <ul>
               <li>Установка приложения.</li>
               <li>Запуск приложения.</li>
               <li>Удаление приложения.</li>
            </ul>
         </details>
         <details><summary>Исследовательское тестирование.</summary>
            <ul>
               <li>Определение границ приложения.</li>
               <li>Определение функционала приложения.</li>
            </ul>
         </details>
         <details><summary>Тестирование UI</summary>
            <ul>
               <li>Проверка отображенния элементов страниц приложения.</li>
            </ul>
         </details>
         <details><summary>Функционально тестирование.</summary>
            <ul>
               <li>Тестирование функционала приложения.</li>
               <li>Переход по ссылкам внешних ресурсов из приложения.</li>
            </ul>
         </details>
         <details><summary>Тестирование безопасности.</summary>
            <ul>
               <li>Тестирование авторизации.</li>
               <li>Проверка защищенности передачи данных через прокси.</li>
            </ul>
         </details>
         <details><summary>Конфигурационное тестирование.</summary>
            <ul>
               <li>
                  <details><summary>Конфигурационное тестирование UI</summary>
                     <ul>
                        <li>Проверка отображения элементов страниц приложения с использованием тёмной/светлой темы устройства.</li>
                        <li>Проверка отображения элементов страниц приложения с изменением размера шрифта.</li>
                        <li>Проверка отображения элементов страниц с изменением языка устройства.</li>
                        <li>Проверка отображения элементов страниц с изменением ориентации экрана устройства.</li>
                     </ul>
                  </details>
               <li>Тестирование приложения с нестабильным/отсутствующим сигналом сети.</li>
               <li>Тестирование работы приложения при вызове/сворачивании в фоновый режим.</li>
               <li>Тестирование обработки ошибок при подменах ответов сервера через прокси.</li>
            </ul>
         </details>
         <details><summary>Автоматизированное тестирование.</summary>
            <ul>
               <li>Автоматизация UI тестов.</li>
               <li>Автоматизация функциональных тестов.</li>
               <li>Автоматизация тестирования авторизации.</li>
            </ul>
         </details>
      </ul>
   </details>

<h2><a id=title4>Инструменты и устройства</a></h2>
   <details><summary>Устройства и эмуляторы</summary>
      <ul>
         <li>Устройство Samsung Galaxy A22, Android 13. Для проведения ручного тестирования.</li>
         <li>Эмулятор Android API 29. Для проведения автоматизированного тестирования.</li>
      </ul>
   </details>
   <details><summary>Инструменты</summary>
      <ul>
         <li>Chalres Proxy. - Прокси-сервер для отсеживания трафика и подмены данных.</li>
         <li>Java 11. - Язык написания автотестов.</li>
         <li>Android Studio. - Среда разработки для Android проектов. Наличие Androiэмулятора с API.</li>
         <li>Espresso Testing Framework. - Тестовый фреймворк с открытым исходным кодомПозволяет создавать тестовые сценарии пользовательского интерфейса с доступом исходному коду.</li>
         <li>Allure. - Инструмент для создания отчетов о результатах тестирования в автоматизированых тестовых сценариях.</li>
      </ul>
   </details>

<h2><a id="title5" href="CheckList.xlxs">Чек-лист</a></h2>

<h2><a id="title6" href="TestCases.xlxs">Тест-кейсы</a></h2>

<h2><a id="title7">Ручное тестирование</a></h2>
   <details><summary>Время на выполнение</summary>
      <ul>
         <li>Расчетное написание тест-кейсов - 6 часов.</li>
         <li>Фактическое написание тест-кейсов - 9 часов.</li>
         <li>Расчетное время выполнения тест-кейсов - 4 часа 40 минут.</li>
         <li>Фактическое время выполнения тест-кейсов - 4 часа 40 минут.</li>
      </ul>
   </detais>

<h2><a id="title8" href="BugReports.md">Баг-репорты ручного тестирования</a></h2>

<h2><a id="title9" href="ReportManual.md">Отчёт ручного тестирования</a></h>

<h2><a id="title10">Анализ результатов ручного тестирования</a></h2>
   <details><summary>Рекомендации</summary>
      <ul>
         <li>Добавить адаптацию UI приложения к использованию тёмной темы устройства.</li>
         <li>Добавить адаптацию UI приложения к использованию различных шрифтов устройства.</li>
         <li>Добавить таймауты соединений с сервером приложения, при различных режимах интернет    соединения.</li>
         <li>
            <details><summary>Автоматизировать тест-кейсы тестирования UI, тестирования функционала, тестирования авторизации.</summary>
               <details><summary>Преимущества:</summary>
                  <ul>
                     <li>Экономия времени</li>
                     <li>Экономия трудозатратности</li>
                     <li>Исключение "человеческого фактора"</li>
                     <li>Автогенерация отчетов</li>
                     <li>Логирование ошибок при "падениях"</li>
                  </ul>
               </details>
               <details><summary>Недостатки:</summary>
                  <ul>
                     <li>Ограниченность API не выше 29 версии</li>
                     <li>Смена индикаторов</li>
                     <li>Обновление модулей приложения</li>
                     <li>Более высокая квалификация тестировщика, по сравнению с ручным тестировщиком</li>
                  </ul>
               </details>
            </details>
         </li>   
      </ul>
   </details>

<h2><a id="title11">Настройка тестового окружениия</a></h2>
   <details><summary>Локальный ПК</summary>
      <ul>
         <li>Установка JDK 11</li>
         <li>Настройка переменной JAVA_HOME на установленную JAVA 11</li>
         <li>Установка Android Studio</li>
         <li>Установка последней стабильной версии Android SDK</li>
         <li>Установка Allure</li>
      </ul>
   </details>
      <details><summary>Проект</summary>
         <ul>
            <li>Определение используемой версии JAVA проекта на локальном ПК</li>
            <li>Добавление зависимостей и фреймворков (Junit4, espresso) в проект</li>
            <li>Добавление зависимостей и файлов конфигураций инструмента отчетности (Allure) в проект</li>
            <li>Добавление дополнительных классов (TimeoutEspresso) для оптимизации проведения тестирования</li>
            <li>Создание эмулятора Android API 29</li>
         </ul>
      </details>
   </details>

<h2><a id="title12">Автоматизированное тестирование</a></h2>
   <details><summary>Время на выполнение:</summary>
      <ul>
         <li>Расчетное время написания тест-кейсов - 20 часов.</li>
         <li>Фактическое  время написания тест-кейсов - 120 часов.</li>
         <li>Расчетное время выполнения тест-кейсов - 30 минут.</li>
         <li>Фактическое время выполнения тест-кейсов - 30 минут.</li>
      </ul>
   </details>

<h2><a id="title13">Сценарий автоматизации</a></h2>
   <details><summary><b>Функциональное тестирование.</b></summary>
      <ul>
         <li>Функциональное тестирование методом белого ящика.</li>
            <ul>Цель функцтонального тестирования - проверка работоспособности функций приложения;</ul>
         <li>UI-тестирование.</li>
            <ul>UI-тестирование - проверка пользовательского интерфейса на соответствие ожиданиям и требованиям.</ul>
      </ul>
   </details>
   <details><summary>Проверяемый функционал:</summary>
      <ul>
         <li>Авторизация и логаут пользователя.</li>
         <li>Добавление новой новости.</li>
         <li>Работа с существующими новостями.</li>
         <li>Просмотр о приложении по ссылкам.</li>
         <li>Просмотр тематических цитат.</li>
      </ul>
   </details>
   <details><summary><b>Нефункциональное тестирование.</b></summary>
      <ul>
         <li>Инсталяционное тестирование.</li>
         <li>Тестирование локализаций.</li>
         <li>UI-тестирвоание.</li>
         <li>Тестирование совместимости.</li>
      </ul>
   </details>


<h2><a id="title14" href="ReportAuto.md">Отчет автоматизированного тестирования</a></h2>

<h2><a id="title15">Анализ результатов автоматизированного тестирования</a></h2>
Выводы по результатам автоматизации тест-кейсов
   <details><summary>Преимущества:</summary>
      <ul>
         <li>Экономия времени прогона тестов относительно ручного тестирования.</li>
         <li>Экономия "человеческого ресурса".</li>
         <li>Исключение "человеческого фактора".</li>
      </ul>
   </details>
   <details><summary>Недостатки:</summary>
      <ul>
         <li>Большие по времени затраты на автоматизацию тест-кейсов.</li>
         <li>Нет возможности всё автоматизировать.</li>
         <li>Ложные падения тестов. Отсутствие корректных селекторов у ряда элементов. Вынужденное использование нестабильных селекторов.</li>
         <li>Необходимо поддерживать актуальность автоматизированных тест-кейсов.</li>
         <li>Сложность в проведении тестирования на устройствах выше API 29, из-за ограничения использования скрытых API.</li>
      </ul>
   </details>