package ru.sbt.course;

/**
 * PinValidator - класс проверки пин-кода
 */

public class PinValidator {
    private final String pinCode = "1357";
    private int missCount;
    private boolean locked;
    private long unlockTime;
    private final long lockPeriod = 5000L;

    public PinValidator() {
        missCount = 0;
        locked = false;
    }

    void validate(String pin) throws WrongPinException {
        if (locked) {
            long timeToUnlock = unlockTime - System.currentTimeMillis();
            if (timeToUnlock > 0L)
                throw new WrongPinException("Аккаунт заблокирован. До разблокировки " + (0.001 * timeToUnlock));
            locked = false;
        }

        if (!pinCode.equals(pin)) {
            missCount++;
            if (missCount > 2) {
                locked = true;
                unlockTime = System.currentTimeMillis() + lockPeriod;
                missCount = 0;
            }
            throw new WrongPinException("Не правильный пин-код");
        }
    }


}
