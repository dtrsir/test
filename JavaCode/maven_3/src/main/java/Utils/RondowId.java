package Utils;

import java.util.UUID;

public class RondowId {
    //该方法用于返回一个随机ID
    public static String getID(){
      return UUID.randomUUID().toString().replaceAll( "_","" );


    }
    }

