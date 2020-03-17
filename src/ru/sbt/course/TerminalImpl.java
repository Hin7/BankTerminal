package ru.sbt.course;

public class TerminalImpl {
    private final PinValidator pinValidator = new PinValidator();
    private long ballance = 200L;
    private long ballanceStep = 100L;

    public long getBallance(String pin) throws WrongPinException {
        pinValidator.validate(pin);
        return ballance;
    }

    public void getCash(String pin, long cash) throws WrongPinException, TerminalException {
        pinValidator.validate(pin);
        if (cash % ballanceStep > 0)
            throw new TerminalException("Снимаемая сумма не кратна " + ballanceStep);
        if (ballance - cash < 0)
            throw new TerminalException("Не достаточно средств на счету");
        ballance -= cash;
    }

    public void addBallance(String pin, long cash) throws WrongPinException, TerminalException {
        pinValidator.validate(pin);
        if (cash % ballanceStep > 0)
            throw new TerminalException("Снимаемая сумма не кратна " + ballanceStep);
        ballance += cash;
    }

}
