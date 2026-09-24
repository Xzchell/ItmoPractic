#Cоздание каталога lab0 и его внутренних каталогов
mkdir lab0
cd lab0

# 1.1 Создание каталогов и файлов
echo "Выполнение 1.1 шага ...."
touch altaria
touch bellsprout
touch haxorus

# -p - параметр, помогающий создать недостающие директории и при налчии уже сущ. директории, ошибки не будет

mkdir -p medicham/electivire
mkdir -p medicham/mightyena
touch medicham/cherubi
touch medicham/clefairy

mkdir -p scolipede/mantyke
touch scolipede/kakuna
mkdir -p scolipede/musharna
touch scolipede/oshawott

mkdir skorupi
mkdir -p skorupi/abomasnow
touch skorupi/chandelure
mkdir -p skorupi/spinarak
touch skorupi/buneary

echo -e "1.1 шаг выполнен\n================================================"

# 1.2 Внесение данных в файлы 
echo "Выполнение 1.2 шага ...."

# -e - параметр echo, который отвечает за перенос строки

echo "Тип диеты = Herbivore" > altaria
echo -e "Способности = Overgrow Venom Chlorophyll\nOblivious" > bellsprout
echo "Тип покемона = DRAGON NONE" > haxorus
echo -e "Возможности = Overland=4 Surface=2\nJump=4 Power=1 Intelligence=3" > medicham/cherubi
echo "Развитые способности = Friend Guard" > medicham/clefairy
echo -e "Тип диеты = Nullivore" > scolipede/kakuna
echo -e "Возможности = Overland=6 Surface=8\nUnderwater=6 Jump=2 Power=2\nIntelligence=3 Fountain=0" > scolipede/oshawott
echo "Тип диеты = Nullivore" > skorupi/chandelure 
echo "Способности = Last Chance Run Away Klutz" > skorupi/buneary

echo -e "1.2 шаг выполнен\n================================================"


# 2. Выдача прав на файлы и каталоги
echo "Выполнение 2 шага ...."

# Кратко про работу прав: существует

chmod u=,g=,o=rw altaria
chmod 440 bellsprout
chmod 600 haxorus
chmod u=wx,g=wx,o= medicham
chmod 570 medicham/electivire
chmod u=rw,g=r,o=r medicham/cherubi
chmod u=rx,g=rwx,o= medicham/mightyena
chmod 444 medicham/clefairy
chmod 555 scolipede
chmod u=rwx,g=rx,o=x scolipede/mantyke
chmod 404 scolipede/kakuna
chmod u=rwx,g=rwx,o= scolipede/musharna
chmod u=r,g=,o=r scolipede/oshawott
chmod u=rwx,g=x,o=x skorupi
chmod 770 skorupi/abomasnow
chmod u=rw,g=rw,o= skorupi/chandelure
chmod u=rx,g=,o= skorupi/spinarak 
chmod u=rw,g=rw,o=r skorupi/buneary
echo -e "2 шаг выполнен\n================================================"

# 3 Копирование часть дерева и создание ссылок внутри дерева

echo "Выполнение 3 шага ...."

chmod u+r medicham
chmod u+r altaria
chmod u+w medicham/electivire

# Выполнение команд из 3 пункта
cp -R medicham scolipede/mantyke
cat altaria > medicham/cherubialtaria
cat skorupi/chandelure medicham/clefairy > bellsprout_58
cp bellsprout medicham/electivire
ln altaria medicham/clefairyaltaria
ln -s medicham Copy_75
ln -s ../bellsprout medicham/cherubibellsprout

chmod u-r scolipede/mantyke/medicham
chmod u-r altaria
chmod u-w medicham/electivire

echo -e "3 шаг выполнен\n================================================"

# 4 Поиск и фильтрация файлов/каталогов и обработка ошибок прав доступа

echo "Выполнение 4 шага ...."

# 4.1 Подсчет символов в altaria и добавление результата в этот же файл
echo "== 4.1 =="

chmod u+rw altaria
wc -m altaria >> altaria 2> /tmp/lab0_errors.log
chmod u-rw altaria

# 4.2 Вывод последних 2-х элементов рекурсивного списка каталогов, сортируя по дате доступа по возрастанию
echo "== 4.2 =="

ls -dFutrl * */* */*/* 2>&1 | grep -v "/$" | tail -2

# 4.3
echo "== 4.3 =="

cat $(ls -dF scolipede/* | grep -v "/$") 2>/dev/null | grep -iv "re"

# 4.4 Подсчет кол-во символов в нескольких файлов и вывод сдеlлать по убыванию кол-ва результата счета
echo "== 4.4 =="

wc -m medicham/cherubi medicham/clefairy scolipede/kakuna scolipede/oshawott skorupi/chandelure 2>/tmp/lab0_errors.log  | sort -nr 

# 4.5
echo "== 4.5 =="

ls -dFutrl a* */a* | grep -v "/$" | head -2

# 4.6
echo "== 4.6 =="

chmod u+r altaria
cat $(ls -dF a* */a* | grep -v "/$") | sort -r | cat -n
chmod u-r altaria

echo -e "4 шаг выполнен\n================================================"

echo "Выполнение 5 шага ...."
# -f удаление файла без подтверждения
chmod u+w medicham/electivire

rm -f altaria
rm -f medicham/clefairy
rm -f Copy_*
rm -f medicham/clefairyaltar*
rm -rf medicham/electivire
rm -rf medicham

echo -e "5 шаг выполнен\n================================================"

echo "Конец выполнения программы"