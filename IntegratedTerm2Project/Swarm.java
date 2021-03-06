
import processing.core.*;
import java.util.*;

class Swarm extends Animation {

  ArrayList<Particle> swarm;
  int numPart = 100; //change to ammount of points in threshold of start frame


  Swarm(PApplet p) {
    super();
    swarm = new ArrayList();

    for (int i = 0; i < numPart; i++) {
      swarm.add(new Particle(x, y, p));
    }
  }

  void display(PApplet p) {
    super.display(p);
    for (int i = 0; i < swarm.size(); i++) {
      Particle pa = swarm.get(i);
      pa.display(p);
      pa.move(p, swarm);

      //If the boolean returns true remove particles and add new ones in their place
      if (pa.dead()) {
        swarm.remove(i);
        swarm.add(new Particle(x, y, p));
      }
    }
  }
}