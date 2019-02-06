/**
 * PA5obj.java
 * 
 * call setP method
 * setP: local object
 * WB, 4/12
 */

import meggy.Meggy;

class PA5obj {

    public static void main(String[] whatever){
        new C().setP((byte)3,(byte)7,Meggy.Color.BLUE);
    }
}

class C {
    Ind oy;
    public void setP(byte x, byte y, Meggy.Color c) {
        Ind ox; ox = new Ind(); ox.put(x);
                oy = new Ind(); oy.put(y);
		Meggy.setPixel(ox.get(), oy.get(), c);    
    }
}

class Ind{
    byte _i;
    public void put(byte i){
	_i = i;
    }
    public byte get(){
	return _i;
    }
}