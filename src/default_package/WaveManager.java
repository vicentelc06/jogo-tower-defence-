package default_package;

public class WaveManager {

    Enemy[] monstros = new Enemy[200];
    int i = 0;



    public void ondas(int wave){

      switch(wave){
          case 1:

            monstros[0] = new Mariposa(3,10);
            monstros[1] = new Barata(1,8);
            monstros[2]= new Mariposa(2,9);
            monstros[3] = new Barata(5, 12);
            monstros[4] = new Mariposa(5, 8);


          break;
          case 2:
              monstros[5] = new Barata(1,8);
              monstros[6]= new Mariposa(2,7);
              monstros[7] = new Barata(4, 8);
              monstros[8] = new Barata(5, 10);
              monstros[9] = new Mariposa(5, 8);
              monstros[10] = new Besouro(0, 10);

          break;
          case 3:

              monstros[11] = new Barata(2,7);
              monstros[12] = new Barata(0,8);
              monstros[13] = new Mariposa(1,7);
              monstros[14] = new Aranha(5, 12);
              monstros[15] = new Aranha(5, 10);
              monstros[16] = new Besouro(3, 10);
              monstros[17] = new Barata(1, 12);
              monstros[18] = new Besouro(4, 8);

              break;

          case 4:

              monstros[19] = new Mariposa(2, 7);
              monstros[20] = new Mariposa(2, 12);
              monstros[21] = new Barata(0, 8);
              monstros[22] = new Aranha(1, 10);
              monstros[23] = new Barata(3, 9);
              monstros[24] = new Besouro(5, 13);
              monstros[25] = new Mariposa(5, 10);
              monstros[26] = new Barata(3, 10);

              break;

          case 5:

              monstros[27] = new Lacraia(2, 12);
              monstros[28] = new Lacraia(3, 10);
              monstros[29] = new Mariposa(1, 8);
              monstros[30] = new Aranha(5, 8);
              monstros[31] = new Aranha(4, 9);

              break;

          case 6:

              monstros[32] = new Aranha(0, 8);
              monstros[33] = new Barata(0, 11);
              monstros[34] = new Barata(2, 10);
              monstros[35] = new Besouro(5, 10);
              monstros[36] = new Besouro(4, 8);
              monstros[37] = new Besouro(1, 12);
              monstros[38] = new Mariposa(1, 9);
              monstros[39] = new Besouro(3, 8);

              break;

          case 7:

              monstros[40] = new Lacraia(1, 12);
              monstros[41] = new Lacraia(4, 10);
              monstros[42] = new Lacraia(5, 10);
              monstros[43] = new Besouro(2, 9);
              monstros[44] = new Aranha(0, 7);
              monstros[45] = new Besouro(3, 8);

              break;

          case 8:

              monstros[46] = new Barata(0, 8);
              monstros[47] = new Barata(1, 7);
              monstros[48] = new Barata(2, 13);
              monstros[49] = new Besouro(3, 9);
              monstros[50] = new Besouro(4, 10);
              monstros[51] = new Besouro(5, 13);
              monstros[52] = new Aranha(2, 9);
              monstros[53] = new Aranha(5, 10);
              monstros[54] = new Barata(1, 13);

              break;

          case 9:

              monstros[55] = new Aranha(0, 8);
              monstros[56] = new Lacraia(1, 12);
              monstros[57] = new Mariposa(1, 8);
              monstros[58] = new Besouro(2, 9);
              monstros[59] = new Lacraia(3, 13);
              monstros[60] = new Mariposa(3, 8);
              monstros[61] = new Besouro(4, 8);
              monstros[62] = new Besouro(4, 11);
              monstros[63] = new Aranha(5, 7);
              monstros[64] = new Besouro(5, 9);
              monstros[65] = new Besouro(0, 10);

              break;

          case 10:

              monstros[66] = new Lacraia(0, 10);
              monstros[67] = new Lacraia(1, 10);
              monstros[68] = new Lacraia(2, 10);
              monstros[69] = new Lacraia(3, 10);
              monstros[70] = new Lacraia(4, 10);
              monstros[71] = new Lacraia(5, 10);

              break;


      }

}

}
