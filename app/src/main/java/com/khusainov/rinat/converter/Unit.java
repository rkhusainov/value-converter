package com.khusainov.rinat.converter;

public class Unit {

    enum ValueTypes {
        Длина,
        Масса,
        Температура,
        Объем,
        Площадь,
        Давление,
        Напряжение,
        Ток,
        Сопротивление,
        Плотность,
        Время,
        Скорость,
        Готовка;

        ValueTypes() {
        }
    }

    enum Length {
        Метр(1.0),
        Километр(0.001),
        Миллиметр(1000),
        Сантиметр(100),
        Дицеметр(10);

        double value;

        Length(double value) {
            this.value = value;
        }
    }

    enum Mass {
        Грамм(1.0),
        Миллиграмм(1000),
        Килограмм(0.001),
        Тонна(0.000001);

        double value;

        Mass(double value) {
            this.value = value;
        }
    }
}
