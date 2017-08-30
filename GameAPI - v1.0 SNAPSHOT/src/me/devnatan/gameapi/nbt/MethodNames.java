package me.devnatan.gameapi.nbt;

public class MethodNames {
	
	protected static String getTiledataMethodName(){
        MinecraftVersion v = MinecraftVersion.getVersion();
        if(v == MinecraftVersion.MC1_8_R3){
            return "b";
        }
        
        return "save";
    }

    protected static String getTypeMethodName(){
        MinecraftVersion v = MinecraftVersion.getVersion();
        if(v == MinecraftVersion.MC1_8_R3){
            return "b";
        }
        
        return "d";
    }

    protected static String getEntitynbtgetterMethodName(){
        return "b";
    }

    protected static String getEntitynbtsetterMethodName(){
        return "a";
    }
    
    protected static String getremoveMethodName(){
        MinecraftVersion v = MinecraftVersion.getVersion();
        if(v == MinecraftVersion.MC1_8_R3){
            return "a";
        }
        return "remove";
    }

}
