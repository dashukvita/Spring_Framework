Тема: Введение в Spring Framework

Домашнее задание №1:

Программа по проведению тестирования студентов

Цель задания: создать приложение с помощью Spring IoC, чтобы познакомиться с основной функциональностью IoC, на которой строится весь Spring.

В ресурсах хранятся вопросы и различные ответы к ним в виде CSV файла (5 вопрсов).
Программа должна спросить у пользователя фамилию и имя, спросить 5 вопросов из CSV-файла и вывести результат тестирования.
Вопросы могут быть с выбором из нескольких вариантов или со свободным ответом - на Ваше желание и усмотрение.
Требования:

Все сервисы в программе должны решать строго определённую задачу.
Контекст описывается XML-файлом.
Все зависимости должны быть настроены в IoC контейнере.
Имя ресурса с вопросами (CSV-файла) необходимо захардкодить в XML-файле с контекстом.
CSV с вопросами читается именно как ресурс, а не как файл.
Scanner и стандартные типы в контекст класть не нужно!
Крайне желательно написать юнит-тест какого-нибудь сервиса (оцениваться будет только попытка написать тест).
