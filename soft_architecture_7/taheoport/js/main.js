
const routes = {
    0 : "<h2 style='text-align:center'>Taheoport</h2>\
    <img src='./images/background.jpg' alt='Taheo' style='padding:10px;max-width:100%;height:auto;'>\
    <p style='text-align:center'>Обработка результатов тахеометрической съёмки</p>\
    <p style='text-align:center'>Уравнивание тахеометрических ходов.</p>",
    1 : "<h3>Импорт данных из электронного тахеометра</h3>\
    <p>Taheoport импортирует данные из файлов измерений в собственный формат и сохраняет данные на диске \
    в файле с расширением tah. Кроме того существует возможность создать файл измерений вручную, \
    воспользовавшись возможностями  редактора измерений. </p>",
    2 : "<h3>Обработка тахеометрической съёмки</h3>\
    <p>Тахеометрическая съёмка выполняется для создания планов или цифровых моделей \
    участков местности в крупных масштабах (1: 500 – 1: 5000).</p>",
    3 : "<h3>Уравнивание тахеометрических ходов ходов</h3>\
    <p>Тахеометрическим ходом называют построенную на местности разомкнутую или замкнутую \
    ломанную линию, проложенную (в общем случае) между пунктами с известными координатами, в которой\
    измерены все стороны, горизонтальные углы между ними и вертикальные углы с каждой точки хода на\
    смежные с ней точки.</p>", 
}
const futer = '<p>Copyright © Низовкин А.В. 2000г.</p>\
<p>Техническая поддержка: <a href="mailto:andreynizovkin@inbox.ru">andreynizovkin@inbox.ru</a></p>\
';

document.getElementById("demo").innerHTML = routes[0];
document.getElementById("myfooter").innerHTML = futer;
function reloadArticle(choice) {
    switch(choice) {
        case 0:
            document.getElementById("demo").innerHTML = routes[0];
        break;
        case 1:
            document.getElementById("demo").innerHTML = routes[1];
        break;
        case 2:
            document.getElementById("demo").innerHTML = routes[2];
        break;
        case 3:
            document.getElementById("demo").innerHTML = routes[3];
        break;
    }

}