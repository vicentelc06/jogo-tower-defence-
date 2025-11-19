package default_package;

public class WaveManager {

    Enemy[] monstros = new Enemy[200];
    int i = 0;



    public void ondas(int wave){

      switch(wave){
          case 1:

            monstros[0] = new InimigoTipo2(3,10);
            monstros[1] = new InimigoTipo1(1,8);
            monstros[2]= new InimigoTipo2(2,9);
            monstros[3] = new InimigoTipo1(5, 12);
            monstros[4] = new InimigoTipo2(5, 8);


          break;
          case 2:
              monstros[5] = new InimigoTipo1(1,8);
              monstros[6]= new InimigoTipo2(2,7);
              monstros[7] = new InimigoTipo1(4, 8);
              monstros[8] = new InimigoTipo1(5, 10);
              monstros[9] = new InimigoTipo2(5, 8);
              monstros[10] = new InimigoTipo3(0, 10);

          break;
          case 3:

              monstros[11] = new InimigoTipo1(2,7);
              monstros[12] = new InimigoTipo1(0,8);
              monstros[13] = new InimigoTipo2(1,7);
              monstros[14] = new InimigoTipo4(5, 12);
              monstros[15] = new InimigoTipo4(5, 10);
              monstros[16] = new InimigoTipo3(3, 10);
              monstros[17] = new InimigoTipo1(1, 12);
              monstros[18] = new InimigoTipo3(4, 8);

              break;

          case 4:

              monstros[19] = new InimigoTipo2(2, 7);
              monstros[20] = new InimigoTipo2(2, 12);
              monstros[21] = new InimigoTipo1(0, 8);
              monstros[22] = new InimigoTipo4(1, 10);
              monstros[23] = new InimigoTipo1(3, 9);
              monstros[24] = new InimigoTipo3(5, 13);
              monstros[25] = new InimigoTipo2(5, 10);
              monstros[26] = new InimigoTipo1(3, 10);

              break;

          case 5:

              monstros[27] = new InimigoTipo5(2, 12);
              monstros[28] = new InimigoTipo5(3, 10);
              monstros[29] = new InimigoTipo2(1, 8);
              monstros[30] = new InimigoTipo4(5, 8);
              monstros[31] = new InimigoTipo4(4, 9);

              break;

          case 6:

              monstros[32] = new InimigoTipo4(0, 8);
              monstros[33] = new InimigoTipo1(0, 11);
              monstros[34] = new InimigoTipo1(2, 10);
              monstros[35] = new InimigoTipo3(5, 10);
              monstros[36] = new InimigoTipo3(4, 8);
              monstros[37] = new InimigoTipo3(1, 12);
              monstros[38] = new InimigoTipo2(1, 9);
              monstros[39] = new InimigoTipo3(3, 8);

              break;

          case 7:

              monstros[40] = new InimigoTipo5(1, 12);
              monstros[41] = new InimigoTipo5(4, 10);
              monstros[42] = new InimigoTipo5(5, 10);
              monstros[43] = new InimigoTipo3(2, 9);
              monstros[44] = new InimigoTipo4(0, 7);
              monstros[45] = new InimigoTipo3(3, 8);

              break;

          case 8:

              monstros[46] = new InimigoTipo1(0, 8);
              monstros[47] = new InimigoTipo1(1, 7);
              monstros[48] = new InimigoTipo1(2, 13);
              monstros[49] = new InimigoTipo3(3, 9);
              monstros[50] = new InimigoTipo3(4, 10);
              monstros[51] = new InimigoTipo3(5, 13);
              monstros[52] = new InimigoTipo4(2, 9);
              monstros[53] = new InimigoTipo4(5, 10);
              monstros[54] = new InimigoTipo1(1, 13);

              break;

          case 9:

              monstros[55] = new InimigoTipo4(0, 8);
              monstros[56] = new InimigoTipo5(1, 12);
              monstros[57] = new InimigoTipo2(1, 8);
              monstros[58] = new InimigoTipo3(2, 9);
              monstros[59] = new InimigoTipo5(3, 13);
              monstros[60] = new InimigoTipo2(3, 8);
              monstros[61] = new InimigoTipo3(4, 8);
              monstros[62] = new InimigoTipo3(4, 11);
              monstros[63] = new InimigoTipo4(5, 7);
              monstros[64] = new InimigoTipo3(5, 9);
              monstros[65] = new InimigoTipo3(0, 10);

              break;

          case 10:

              monstros[66] = new InimigoTipo5(0, 10);
              monstros[67] = new InimigoTipo5(1, 10);
              monstros[68] = new InimigoTipo5(2, 10);
              monstros[69] = new InimigoTipo5(3, 10);
              monstros[70] = new InimigoTipo5(4, 10);
              monstros[71] = new InimigoTipo5(5, 10);

              break;


      }

}

}
