package com.khusainov.rinat.converter;

import androidx.annotation.StringRes;

public class Unit {

    enum ValueTypes {
        LENGTH(R.string.length),
        MASS(R.string.mass),
        TEMPERATURE(R.string.temperature),
        VOLUME(R.string.volume),
        AREA(R.string.area),
        PRESSURE(R.string.pressure),
        VOLTAGE(R.string.voltage),
        AMPERAGE(R.string.amperage),
        RESISTANCE(R.string.resistance),
        DENSITY(R.string.density),
        TIME(R.string.time),
        SPEED(R.string.speed),
        COOKING(R.string.cooking);

        int mNameRes;

        ValueTypes(@StringRes int nameRes) {
            mNameRes = nameRes;
        }
    }

    enum Length {
        METER(R.string.meter, 1.0),
        KILOMETER(R.string.kilometer, 0.001),
        MILLIMETER(R.string.millimeter, 1000),
        CENTIMETER(R.string.centimeter, 100),
        DECIMETER(R.string.decimeter, 10);

        int mNameRes;
        double value;

        Length(@StringRes int nameRes, double value) {
            this.value = value;
            mNameRes = nameRes;
        }
    }

    enum Mass {
        GRAM(R.string.gram, 1.0),
        MILLIGRAM(R.string.milligram, 1000),
        KILOGRAM(R.string.kilogram, 0.001),
        TON(R.string.ton, 0.000001);

        int mNameRes;
        double value;

        Mass(@StringRes int nameRes, double value) {
            this.value = value;
            mNameRes = nameRes;
        }
    }
}
