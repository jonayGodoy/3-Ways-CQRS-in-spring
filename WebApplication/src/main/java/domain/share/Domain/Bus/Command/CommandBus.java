package domain.share.Domain.Bus.Command;

public interface CommandBus {
    <C extends Command> void ask(C Command);
}
