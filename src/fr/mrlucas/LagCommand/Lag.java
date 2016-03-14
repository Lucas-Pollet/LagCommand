package fr.mrlucas.LagCommand;

import java.util.Calendar;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_8_R3.MinecraftServer;

public class Lag extends JavaPlugin{

	@Override
	public void onEnable() {
        System.out.println("/lag > Enabled !");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		Calendar c = Calendar.getInstance(); 
		
		if(sender instanceof Player){
			if(label.equalsIgnoreCase("lag")){
				
				p.sendMessage("§6§m-----------------------------------------");
				
				p.sendMessage("§r                   §e§l>> Lag's info <<");
				p.sendMessage("");
				p.sendMessage("§eServer: §7"+p.getServer().getServerName());
				p.sendMessage("§eDate: §7" +
				    //Date
						c.get(Calendar.DAY_OF_MONTH) + "/"+ getMonth(c.get(Calendar.MONTH)) + "/" + c.get(Calendar.YEAR) + 
					//Hours	
						" | " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
				p.sendMessage("§ePing: §7"+getPing(p)+"ms");
				
				 StringBuilder sb = new StringBuilder("§6TPS from last 1m, 5m, 15m: " );
			        for (double tps : MinecraftServer.getServer().recentTps)
			        {
			            sb.append( format( tps ) );
			            sb.append( ", " );
			        }
			        
			    p.sendMessage(sb.substring( 0, sb.length() - 2 ));   
			    p.sendMessage("§a20 §7= §aPerfect !");
	           
				p.sendMessage("§6§m-----------------------------------------");
			}
			
		}
		
		return false;
		
	}
	
	public int getPing(Player player) {
	    return ((CraftPlayer) player).getHandle().ping;
	}
	
	 private String format(double tps)
	  {
	    return (tps > 18.0D ? ChatColor.GREEN : tps > 16.0D ? ChatColor.YELLOW : ChatColor.RED).toString() + (
	      tps > 20.0D ? "*" : "") + Math.min(Math.round(tps * 100.0D) / 100.0D, 20.0D);
	  }
	 
	 public int getMonth(int month){
		 if(month == Calendar.JANUARY){
			 return 1;
		 }
		 if(month == Calendar.FEBRUARY){
			 return 2;
		 }
		 if(month == Calendar.MARCH){
			 return 3;
		 }
		 if(month == Calendar.APRIL){
			 return 4;
		 }
		 if(month == Calendar.MAY){
			 return 5;
		 }
		 if(month == Calendar.JUNE){
			 return 6;
		 }
		 if(month == Calendar.JULY){
			 return 7;
		 }
		 if(month == Calendar.AUGUST){
			 return 8;
		 }
		 if(month == Calendar.SEPTEMBER){
			 return 9;
		 }
		 if(month == Calendar.OCTOBER){
			 return 10;
		 }
		 if(month == Calendar.NOVEMBER){
			 return 11;
		 }
		 if(month == Calendar.DECEMBER){
			 return 12;
		 }
		 
		return month;
		
	 }
	 
	 
}
