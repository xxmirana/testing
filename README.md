# Selenium & Appium Automation Project

Этот проект содержит автоматизированные тесты для веб-приложения (Demoblaze) и мобильного приложения (Wikipedia). Для веб-тестирования используется Selenium WebDriver с TestNG, а для мобильного тестирования — Appium с TestNG.

## Требования
1. Java Development Kit (JDK) 11 или выше
2. Apache Maven 3.6+
3. Appium Server 2.0+
4. Для мобильных тестов:
- Android SDK с платформенными инструментами
- Android эмулятор или физическое устройство
- APK-файл Wikipedia 


## Структура проекта
```
selenium-appium-project/
├── src/test/java/
│   ├── pages/          
│   ├── tests/         
│   └── utils/          
├── src/test/resources/
├── apk/                
├── pom.xml            
├── testng-web.xml     
├── testng-mobile.xml   
└── README.md 
```

## Установка и настройка

### 1. Клонирование репозитория
```
git clone <адрес-репозитория>
cd selenium-appium-project
```
### 2. Установка зависимостей
```
mvn clean install
```
### 3. Настройка проекта

При необходимости обновите src/test/resources/config.properties
Поместите APK-файл Wikipedia в apk/wikipedia.apk

## Запуск тестов

### Веб-тесты (Demoblaze)
```
mvn test -Dtestng.xml=testng-web.xml
```
### Мобильные тесты (Wikipedia)
Запустите сервер Appium:
```
appium --address 127.0.0.1 --port 4723
```
Запустите Android эмулятор или подключите устройство
Запустите тесты:
```
mvn test -Dtestng.xml=testng-mobile.xml
```
### Запуск всех тестов
```
mvn test
```
## Тестовые сценарии

### Веб-приложение (4 сценария)

Проверка логотипа на главной странице — Проверяет отображение основного логотипа
Навигация по категориям — Тестирует переход к категориям товаров
Навигация на страницу корзины — Проверяет корректное открытие страницы корзины
Появление модального окна регистрации — Проверяет появление модального окна регистрации

### Мобильное приложение (3 сценария)

Наличие поисковой строки — Проверяет отображение поисковой строки
Поиск и открытие статьи — Ищет статью "Appium" и открывает её
Прокрутка статьи — Ищет статью "Java" и прокручивает её содержимое

## Конфигурация

Основные настройки в файле config.properties:

### Конфигурация для веб-тестов

```
web.base.url=https://www.demoblaze.com
web.browser.name=chrome
```
### Конфигурация для мобильных тестов

```
mobile.app.path=apk/wikipedia.apk
mobile.appium.server.url=http://127.0.0.1:4723
mobile.platform.name=Android
mobile.device.name=emulator-5554
```

## Зависимости

- Selenium WebDriver 4.20.0
- TestNG 7.9.0
- Appium Java Client 9.2.2
- WebDriverManager 5.8.0
