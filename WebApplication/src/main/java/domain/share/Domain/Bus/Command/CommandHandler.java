package domain.share.Domain.Bus.Command;

public interface CommandHandler<C extends Command> {
    void invoke(C command);
}
