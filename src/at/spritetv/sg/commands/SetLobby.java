package at.spritetv.sg.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.spritetv.sg.SG;

public class SetLobby implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) sender;
		if(!p.hasPermission("sg.setlobby")) {
			p.sendMessage(SG.perm);
			return true;
		}
		
		if(args.length != 0) {
			p.sendMessage(SG.prefix + "�cFehler! �7Benutze: /setlobby");
			return true;
		}
		SG.plugin.getConfig().set("Lobby.World", p.getWorld().getName());
		SG.plugin.getConfig().set("Lobby.X", p.getLocation().getX());
		SG.plugin.getConfig().set("Lobby.Y", p.getLocation().getY());
		SG.plugin.getConfig().set("Lobby.Z", p.getLocation().getZ());
		SG.plugin.saveConfig();
		p.sendMessage(SG.prefix + "�7Du hast die �3Lobby �7erfolgreich gesetzt");
		return true;
	}
	

}
