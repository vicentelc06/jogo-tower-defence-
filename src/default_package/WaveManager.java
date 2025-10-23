package default_package;

public class WaveManager {

    Enemy[] monstros = new Enemy[100];
    int i = 0;



    public void ondas(int wave){

      switch(wave){
          case 1:

            monstros[0] = new Inimigo2(1,10);


          break;
          case 2:
              monstros[1] = new Inimigo1(2,8);
              monstros[2]=new Inimigo2(2,7);

          break;
          case 3:

              monstros[3] = new Inimigo1(2,7);
              monstros[4] = new Inimigo1(0,8);
              monstros[5] = new Inimigo2(1,7);

              break;
      }

}

}
