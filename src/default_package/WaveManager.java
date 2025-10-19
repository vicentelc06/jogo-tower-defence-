package default_package;

public class WaveManager {

    Enemy[] monstros = new Enemy[100];
    int i = 0;



    public void ondas(int wave){

      switch(wave){
          case 1:

            monstros[0] = new Inimigo2(1,10);
            monstros[1] = new Inimigo1(2,8);

          break;
          case 2:

              monstros[2]=new Enemy(2,7);

          break;
      }

}

}
