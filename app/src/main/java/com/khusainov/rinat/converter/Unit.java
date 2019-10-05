package com.khusainov.rinat.converter;

public class Unit {

    enum ValueTypes {
        Длина(Length.values()),
        Масса(Mass.values()),
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

        Length[] mLength;
        Mass[] mUnits;

        ValueTypes(Length[] lengths) {
            mLength = lengths;
        }

        ValueTypes(Mass[] masses) {
            mUnits = masses;
        }

        ValueTypes() {
        }
    }

    enum Length {
        Метр(1.0),
        Километр(0.01),
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
        Центнер(0.00001),
        Тонна(0.000001);

        double value;

        Mass(double value) {
            this.value = value;
        }
    }
}
