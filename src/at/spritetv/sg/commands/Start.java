package at.spritetv.sg.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.spritetv.sg.CountdownHandler;
import at.spritetv.sg.SG;

public class Start implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(SG.nospieler);
			return true;
		}
		Player p = (Player) sender;
		if(!p.hasPermission("sg.start")) {
			p.sendMessage(SG.perm);
			return true;
		}
		
		if(args.length != 0) {
			p.sendMessage(SG.prefix + "§cFehler! §7Benutze: /start");
			return true;
		}
		if(CountdownHandler.lobbytimer <= 5) {
		    if(CountdownHandler.lobbytimer > 11) {
				Bukkit.getScheduler().cancelAllTasks();
				CountdownHandler.firstCountdown();
				
				
			}else{
				p.sendMessage(SG.prefix + "§cDas Spiel startet bereits.");
			}

			
		
		return true;
	}

}
