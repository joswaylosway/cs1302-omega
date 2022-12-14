package cs1302.game;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;

/**
 * A simple "sprite" of an idle cat.
 */
public class Ghost extends Circle {

    private Game game; // game containing this sprite
    private double dx; // change in x per update
    private double dy; // change in y per update
    private boolean eatable;
    private boolean trigger;
    public boolean first = true;
    public double dist;
    public int dir;
    /**
     * Construct an {@code IdleCat} object.
     * @param game parent game
     */
    public Ghost(Game game) {
        super(6);
        this.dist = 0;
        this.game = game;
        this.dir = 0;
        eatable = false;

    }

    public double openU(Rectangle[] bounds) {
        Rectangle closest = null;
            double closestDistance = 0;
            for ( Rectangle bound: bounds) {
                Bounds b = bound.getBoundsInParent();

                if (b.getMaxY() <=  this.getBoundsInParent().getMinY()) {
                    double minX =this.getBoundsInParent().getMinX();
                    double maxX =this.getBoundsInParent().getMaxX();

                    if (b.getMaxX() < minX-10 || b.getMinX() > maxX+10) {
                        if (b.getMaxY() > closestDistance) {
                            closestDistance = b.getMaxY();
                            closest = bound;

                }


                    }
                    }

            }
            return this.getBoundsInParent().getMinY() - closestDistance;


    }
    public double openL(Rectangle[] bounds) {
        Rectangle closest = null;
            double closestDistance = 1000;
            double minY =this.getBoundsInParent().getMinY();
            double maxY =this.getBoundsInParent().getMaxY();
            for ( Rectangle bound: bounds) {
                Bounds b = bound.getBoundsInParent();

                if (b.getMaxX() <=  this.getBoundsInParent().getMinX()) {
                    if (b.getMaxY() < minY-10 || b.getMinY() > maxY+10) {
                        if (b.getMinX() < closestDistance) {
                            closestDistance = b.getMinX();
                            closest = bound;

                }
                    }
                    }
            }
            return this.getBoundsInParent().getMinX() - closestDistance;

    }
    public double openR(Rectangle[] bounds) {
        Rectangle closest = null;
            double closestDistance = 0;
            double minY =this.getBoundsInParent().getMinY();
            double maxY =this.getBoundsInParent().getMaxY();
            for ( Rectangle bound: bounds) {
                Bounds b = bound.getBoundsInParent();

                if (b.getMinX() >=  this.getBoundsInParent().getMaxX()) {


                    if (b.getMaxY() < minY-10 || b.getMinY() > maxY+10) {
                        if (b.getMaxX() > closestDistance) {
                            closestDistance = b.getMinX();
                            closest = bound;

                }


                    }
                    }

            }
            return closestDistance - this.getBoundsInParent().getMaxX();

    }
    public double openD(Rectangle[] bounds) {
         Rectangle closest = null;
            double closestDistance = 1000;
            double minX =this.getBoundsInParent().getMinX();
            double maxX =this.getBoundsInParent().getMaxX();
            for ( Rectangle bound: bounds) {
                Bounds b = bound.getBoundsInParent();
                if (b.getMinY() >=  this.getBoundsInParent().getMaxY()) {
                    if (b.getMaxX() < minX-3 || b.getMinX() > maxX+3) {
                        if (b.getMinY() < closestDistance) {
                            closestDistance = b.getMaxY();
                            closest = bound;
                        }


                    }
                    }


    }
            return closestDistance - this.getBoundsInParent().getMaxY();
    }
    public void update(DemoGame game) {

            double r = Math.random();
           int rando = (int)(r * (4-1))+1;
           if (rando == 1) {
               if (this.getY() - 3 > 50) {
                   this.setY(this.getY()-3);
               }

           }
           if (rando == 2) {
               if (this.getY() + 3 < 250) {
                   this.setY(this.getY()+3);
               }

           }
           if (rando == 3) {
               if (this.getX() - 3 > 0) {
                   this.setX(this.getX()-3);
               }

           }
           if (rando == 2) {
               if (this.getX() + 3 < 300) {
                   this.setX(this.getX()+3);
               }

           }
    }



}    // IdleCat
//        boolean left = true;
//  boolean right= true;
//      boolean up = true;
//      boolean down = true;
//      boolean[]  bool = {true,true,true,true};
//      int count = 0;
//      for (Rectangle rect : walls) {
//							if (rect.intersects(
//									new Circle(this.getX() - 3, this.getY(), .1).getBoundsInLocal())) {
//								bool[0] = false;
//

//							}
//
//         if (rect.intersects(
//									new Circle(this.getX() + 3, this.getY(), .1).getBoundsInLocal())) {
//								bool[1] = false;
//


//							}

//           if (rect.intersects(
//									new Circle(this.getX(), this.getY()- 5, .1).getBoundsInLocal())) {
//								bool[2] = false;


//							}

//         if (rect.intersects(
//									new Circle(this.getX(), this.getY()+5, .1).getBoundsInLocal())) {
//								bool[3] = false;


//							}
//      }
//      for (int i = 0; i <bool.length-1; i++) {
//          if (bool[i] == true) {
//              count++;
//          }
//      }
//        int[] rands = new int[count];
//        int coun = 0;
//        for (int i = 0; i< bool.length-1; i++) {
//            if (bool[i] == true) {
//                rands[coun] = i;
//                coun++;
//            }
//        }
//
//         int dir = rands[rando];
//      if ( dir == 0) {
              //            this.setY(this.getY()-1);
//          }
//          if ( dir == 1) {
              //   this.setY(this.getY()+1);
              //         }
//    if ( dir == 2) {
              //this.setX(this.getX()-1);
              //        }
//        if ( dir == 3) {
              //            this.setX(this.getX()+1);
//          }
