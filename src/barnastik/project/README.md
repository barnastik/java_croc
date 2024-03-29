Тема: “сервис-светофор загруженности избирательных участков”

Цель проекта: разработать консольное приложение, которое будет отображать информацию о загруженности избирательных участков. Пользователи смогут видеть текущее состояние каждого избирательного участка и принимать решения на основе этой информации.

Задачи: 
- реализация основных классов (PollingStation,ElectionTrafficLightService)
- реализация функций классов
- обработка ошибок
- реализация меню

Описание классов. 
В classes содержатся классы для работы: 
- PollingStation (класс - станция)
- ElectionTrafficLightService
- ElectionSimulation (симуляция работы)
+ enum Light

В database содержатся классы для взаимодействия с базой данных:
- DataBase
- FileReaderCsv
- Main (тестирование работы)
+ файл csv

//создается бд и в нее записываются данные из файла csv, а потом считываются и используются//

В files фаил txt с данными участков.
ConsoleMenu - класс с меню для взаимодействия с системой (вывод светофора и тд).
Вывод светофора производится от самой менее загруженной к самой загруженной, загруженность определяется как отношение кол-ва избирателей к общей вместимости участка.

Основные функции:
- регистрация нового участка 
- обновление данных об участке (ввод кол-ва избирателей) 
- закрытие участка
- возможность просматривать информацию о конкретном участке
- вывод светофора загруженности по всем станциям и внутри нужной улицы
- вывод всей информации обо всех участках
- вывод средней загруженности по всем участкам
- поиск менее загруженного участка на данной улице
- чтение участков из внешнего источника (файла или базы данных)
- моделирование работы
- завершение программы
