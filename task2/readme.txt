формат файла
- время старта
- координаты начальной точки(с 1)
- координаты конечной точки(с 1)
- карта лабиринта с высотами(если стена, то -1)
- N
- N строк из координат и периода закрывающейся перегородки
- M
- M строк из координат и периода открывающейся перегородки

формат выхода
- YES/NO всегда ли шар, запущенный в момент времени M, достигнет выхода.

решение
в отличие от 1 версии, записываем все точки выхода в рекурсии, и проверяем, что не было выхода не на финише