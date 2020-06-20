package elementosbasicos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MapLoader {
	private Mapa map;
	private static MapLoader ml;
	
	private MapLoader() {
		this.map = null;
	}
	
	//public Map loadMapFromFile(String fileName) {
		
	//}
	
	public static MapLoader getInstance() {
		if(ml == null)
			ml = new MapLoader();
		return ml;
	}
	
//	public Map createDefaultMap() {
//		
//	}

}
