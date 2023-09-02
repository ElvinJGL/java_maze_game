package Components;

import Objects.Point;

public class Map {
    private int mapLevel;

    public Map(int level){
        if (level < 1) level = 1;
        if (level > 4) level = 4;
        this.mapLevel = level - 1;
    }

    public String[] getMap(){
        return Map.maps[mapLevel];
    }

    public Point getPos(char FLAGS){
        for(int r = 0; r < maps[mapLevel].length; r++){
            for(int c = 0; c < maps[mapLevel][r].length(); c++){
                if(FLAGS == 'S')
                    if(maps[mapLevel][r].charAt(c) == 'S') return new Point(c, r);
                if(FLAGS == 'F')
                    if(maps[mapLevel][r].charAt(c) == 'F') return new Point(c, r);
            }
        }
        return new Point();
    }

    public char getBlock(Point point){
        for(int r = 0; r < maps[mapLevel].length; r++){
            for(int c = 0; c < maps[mapLevel][r].length(); c++){
                if(c == point.x && r == point.y) return maps[mapLevel][r].charAt(c);
            }
        }
        return '#';
    }

    public int getWidth() {
        return maps[this.mapLevel][0].length();
    }

    public int getHeight(){
        return maps[this.mapLevel].length;
    }

    private static String[][] maps = {
        {
            "ooooooF",
            "o******",
            "ooooooo",
            "**o****",
            "ooo*ooo",
            "o*****o",
            "ooo***o",
            "**o***o",
            "Soooooo"
        },
        {
            "o*ooo*ooo**",
            "o*o*ooo*o*o",
            "o*o***o*o*o",
            "o*o*Soo*ooo",
            "ooo***o*o**",
            "o*o*ooo*o*o",
            "o*****o*ooo",
            "o*ooo******",
            "ooo*ooooooF"
        },
        {
            "Soo*ooooooo*o",
            "o*o*o***o*o*o",
            "o*ooooo*o*o*o",
            "o*o*o*ooooooo",
            "ooooo*o***o**",
            "****o*o*ooooo",
            "oooooooooo**o",
            "**o******o*oo",
            "oooo*ooooooo*",
            "o**o*********",
            "o*oo*ooo*oooo",
            "o*o**o*o*o**o",
            "o*oooo*oooo*F"
        },
        {
            "ooooooooooooooooo*ooo",
            "o*********o***o*o*o*o",
            "o*ooo*ooo*o*ooo*o*o*o",
            "o*o*ooo*ooo*o**oo*o*o",
            "o*o*******o**ooo**o*o",
            "o*oooooooooooo*oooo*o",
            "o***o*****S*********o",
            "ooo*o*ooo***o*ooooooo",
            "o*o*o*o*o*F*o*o*****o",
            "o*o*o*o*ooo*o*o*ooo*o",
            "**o*o*o*****o*o*o*o*o",
            "ooo***ooooo*****o*o*o",
            "o*ooo*****ooooooo*ooo",
            "o***o*ooo***********o",
            "ooo*ooo*ooooooooooooo"
        }
    };
}
