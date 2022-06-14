package service;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandTool {
      private ServiceSystem serviceSystem;

      public CommandTool(){
          serviceSystem = new ServiceSystem();
    }
    public void parseCommand(String command) {
          final String addService = "(addservice) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+)";
          final String printServiceById = "(printservicebyid) ([0-9]+)";
          final String deleteServiceById = "(deleteservicebyid) ([0-9]+)";
          Matcher matcher = isPatternMatches(command,addService);
          if(matcher.find()){
              String data = matcher.group(2);
              String[] serviceData = data.split(";");
              System.out.println(data);
              serviceSystem.addService(serviceData[0], serviceData[1]);
              System.out.println("Ok");
          }
          matcher = isPatternMatches(command, printServiceById);
          if(matcher.find()) {
              String data = matcher.group(2);
              String[] serviceIdData = data.split(";");
              System.out.println(data);
              int id = Integer.parseInt(serviceIdData[0]);
              serviceSystem.printServiceId(id);
              System.out.println("Ok");
          }
        matcher = isPatternMatches(command, deleteServiceById);
        if(matcher.find()) {
            String data = matcher.group(2);
            String[] serviceDeleteData = data.split(";");
            System.out.println(data);
            int id = Integer.parseInt(serviceDeleteData[0]);
            serviceSystem.deleteServiceById(id);
            System.out.println("Ok");
        }
    }
    public Matcher isPatternMatches(String command, String regex){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(command);
        return matcher;
    }
    public static void main(String[] args) {
        CommandTool commandTool = new CommandTool();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please, type a command");
            String command = sc.nextLine();
            commandTool.parseCommand(command);
        }
    }
}
