package jet.messenger;

/**
 * Parsing arguments to command and executing them.
 *
 * @author Denis Korablev
 */
public class ArgsParser {
    private String systemCommand;
    private Message message;
    private User user;

    public ArgsParser(String[]  args, User user){
        this.user = user;
        commandParser(args);
    }

    public void executeCommands(){
        if (checkNotNull()) {
            switch (systemCommand) {
                case "-u":
                    MessageSender sender = new MessageSender(user,message);
                    sender.sendMessage();
                    return;
                case "-a":
                    MessageSender broadcastSender = new MessageSender(user,message);
                    broadcastSender.broadcast();
                    return;
                case "-l":
                    MessageReceiver receiver = new MessageReceiver(user);
                    receiver.getMessages();
                    return;
                case "limit":
                    return;
            }
        }else{
            System.out.println("Неверно заданы параметры сообщения");
        }
    }

    private void commandParser(String[] args){
        message = new Message();
        for (int i = 0; i < args.length; i++){
            switch (args[i]){
                case "-l":
                    setLCommand(args[i], args[++i]);
                    return;
                case "-u":
                    setUCommand(args[i], args[++i]);
                    break;
                case "-a":
                    systemCommand = args[i];
                    break;
                case "-m":
                    i++;
                    setMCommand(joinInRow(args,i));
                    return;
                case "limit":
                    return;
                default:
                    System.out.println("Команда " + args[i] + " не распознана");
                    return;
            }
        }
    }

    private String joinInRow(String[] teams, int i){
        String str = "";
        for (;i < teams.length; i++){
            str += " " + teams[i];
        }
        return str;
    }

    private boolean checkLimitMessageLenght(String str){
        int limitmessage = 200;
        if((str != null) && (limitmessage > str.length())){
            return true;
        }
        else{

            System.out.println("Превышен лимит сообщения");
        }
        return false;
    }

    private boolean checkNotNull(){
        String str = message.getMessageBody();
        if(systemCommand == null){
            return false;
        } else if (user == null ){
            return false;
        } else if((message == null)){
            return false;
        }else if ((str.equals("") && str.equals(" "))){
            return false;
        }
        return true;
    }

    private void setUCommand(String command, String userName){
        systemCommand = command;
        message.setRecieverUserId(userName);

    }

    private void setLCommand(String command, String userName){
        systemCommand = command;
        message.setRecieverUserId(userName);
    }

    private void setMCommand(String str){
        if(!checkLimitMessageLenght(str)){
            systemCommand = "limit";
        }else {
            message.setMessageBody("[" +  user.getUserID() + "]: " + str);
        }
    }
}
