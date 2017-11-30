
package caro;

import java.util.List;
import java.awt.Point;
import java.util.ArrayList;


public class Banco {
    public int player_X = 10;
    public int player_O = -10;
    public Point point_pc = null;
    public int best;
    public int[][] banco = new int[3][3];
    
    
    public int nutLa() {
        if( banco[0][0] == banco[1][1] && banco[0][0] == banco[2][2]) {
            if( banco[0][0] == player_X) return 10;
            if( banco[0][0] == player_O) return -10;
        }
        if( banco[0][2] == banco[1][1] && banco[0][2] == banco[2][0]) {
            if( banco[0][2] == player_X) return 10;
            if( banco[0][2] == player_O) return -10;
        }
        for( int i = 0; i < 3; i++ ){
            if( banco[i][0] == banco[i][1] && banco[i][0] == banco[i][2]) {
                if(banco[i][0] == player_X) return 10;
                if(banco[i][0] == player_O) return -10;
            }
            if( banco[0][i] == banco[1][i] && banco[0][i] == banco[2][i]){
                if(banco[0][i] == player_X) return 10;
                if(banco[0][i] == player_O) return -10;
            } 
        }
        return 0;
    }
    
    
    public int giaTri(int player){
        int gtri_player = 0;
        for ( int i = 0; i < 3; i++ ){
            if( (banco[i][0] == 0 || banco[i][0] == player) && (banco[i][1] == 0 || banco[i][1] == player) && (banco[i][2] == 0 || banco[i][2] == player) ){
                gtri_player++;
            }
            if( (banco[0][i] == 0 || banco[0][i] == player) && (banco[1][i] == 0 || banco[1][i] == player) && (banco[2][i] == 0 || banco[2][i] == player) ){
                gtri_player++;
            }
        }
        if( (banco[0][0] == 0 || banco[0][0] == player) && (banco[1][1] == 0 || banco[1][1] == player) && (banco[2][2] == 0 || banco[2][2] == player) ){
            gtri_player++;
        }
        if( (banco[0][2] == 0 || banco[0][2] == player) && (banco[1][1] == 0 || banco[1][1] == player) && (banco[2][0] == 0 || banco[2][0] == player) ){
            gtri_player++;
        }
        return gtri_player;
    }
    
    
    public List<Point> dscon(){
        List<Point> listPoint = new ArrayList<Point>();
        for( int i = 0; i < 3; i++ ){
            for( int j = 0; j < 3; j++){
                if( banco[i][j] == 0 ){
                    listPoint.add(new Point(i,j));
                }
            }
        }
        return listPoint;
    }
    
    public int cat_tia(int player, int depth, int Vp){
        int Vq ;
        
//        for(int i = 0; i< 3; i++){
//            for(int j = 0; j< 3; j++){
//                System.out.print(banco[i][j]);
//            }
//            System.out.println("    ");
//        }
        int nutLa = nutLa();
        if(nutLa != 0 ) return Vq = nutLa;
        if( depth == 0 ){
            return Vq = giaTri(player_X) - giaTri(player_O);
        }
        if( player == player_X ){
            Vq = -20;
        }
        else Vq = 20;
        List <Point> dscon = dscon();
        if( dscon.isEmpty()) return Vq = 0;
        for( int i = 0; i < dscon.size(); i++ ){
            Point point = dscon.get(i);
            banco[point.x][point.y] = player;
            if( player == player_X) {
                Vq = Math.max(Vq, cat_tia( player_O, depth - 1, Vq));
                banco[point.x][point.y] = 0;
                if( Vp <= Vq ) return Vq;
            }
            else{
                Vq = Math.min(Vq, cat_tia( player_X, depth - 1, Vq));
                if( Vq < best && depth == 3){
                    best = Vq;
                    point_pc = point;
                }
                banco[point.x][point.y] = 0;
                if( Vp >= Vq ) return Vq;
            }
        }
        return Vq;    
    }
    
}
