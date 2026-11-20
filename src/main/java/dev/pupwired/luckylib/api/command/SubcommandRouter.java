package dev.pupwired.luckylib.api.command;

import org.bukkit.command.CommandSender;

import java.util.*;

/** Finds a subcommand by the first argument and hands it the rest. */
public final class SubcommandRouter {

    private final Map<String, Subcommand> byName = new LinkedHashMap<>();

    public SubcommandRouter(Subcommand... subcommands) {
        for (Subcommand sub : subcommands) byName.put(sub.name().toLowerCase(Locale.ROOT), sub);
    }

    /** @return false if no subcommand matched, so the caller can show its usage */
    public boolean dispatch(CommandSender sender, String label, String[] args) {
        if (args.length == 0) return false;
        Subcommand sub = byName.get(args[0].toLowerCase(Locale.ROOT));
        if (sub == null) return false;
        sub.execute(sender, label, Arrays.copyOfRange(args, 1, args.length));
        return true;
    }

    public List<String> complete(CommandSender sender, String[] args) {
        if (args.length == 0) return List.of();
        if (args.length == 1) return Completions.filter(byName.keySet(), args[0]);
        Subcommand sub = byName.get(args[0].toLowerCase(Locale.ROOT));
        if (sub == null) return List.of();
        return sub.complete(sender, Arrays.copyOfRange(args, 1, args.length));
    }
}