package controleur;


import model.Tortue;
import model.TortueFlocking;

import java.awt.*;

/**
 * Created by lafay on 10/05/2017.
 */
public class ControlerManipTortueFlocking extends ControlerManipTortue{


        /**
                * Tells each Bird in the Vector to move in the direction of the generalHeading.
            *
            * @return  A vector of birds that were removed. This is used to update the
 *           sliders for the number of birds still on the map.
            */
    synchronized public void move() {
        boolean predatorIsFull = false;
        boolean ateBird = false;
        int movingTortue = 0;

        // Loop through each bird to move.
        // Done this way, because the vector can change in the loop
        while (movingTortue < getListeTortues().size()) {
            predatorIsFull = false;
            ateBird = false;


            Tortue tortue = (Tortue) getListeTortues().get(movingTortue);
            tortue.move(generalHeading(tortue));




        }

    }

    /**
     * This function determines the direction a Bird will turn towards for this step.
     * The bird looks at every other bird and obstacle on the map to see if it is
     * within the detection range. Predator will move toward birds. Birds will
     * avoid birds of a different color and all obstacles.
     *
     * @param  tortue The bird to get the heading for
     */
    private int generalHeading(TortueFlocking tortue) {

        // Sum the location of all birds that are within our detection range
        Point target = new Point(0, 0);

        //int targetX,targetY=0;
        // Number of birds that are within the detection range
        int numBirds = 0;

        // Loop thorough each bird to see if it is within our detection range
        for (int i=0; i < getListeTortues().size(); i++) {
            Tortue autresTortue = (Tortue) getListeTortues().get(i);
            int autreX,autreY =0;
            Point otherLocation = closestLocation(new Point(tortue.getPosX(), tortue.getPosY()), new Point(autresTortue.getPosX(), autresTortue.getPosY()));

            // get distance to the other Bird. Note, this distance accounts for
            // the fact that the shortest path may be through the edge of the map
            int distance = tortue.getDistance(autresTortue);

            if (!tortue.equals(autresTortue) && distance > 0 && distance <= tortue.separation)
            {
            /*
             * If the other bird is the same color, the algorithm tells the
             * bird to align its direction with the other Bird. If the distance
             * between them differs from DetectionRange then a weighted forces
             * is applied to move it towards that distance. This force is
             * stronger when the birds are very close or towards the limit of detection.
             */
                if (tortue.getColor().equals(autresTortue.getColor())) { // birds of same color attract
                    Point align = new Point((int)(100 * Math.cos(autresTortue.getDir() * Math.PI/180)),
                            (int)(-100 * Math.sin(autresTortue.getDir() * Math.PI/180)));
                    align = normalisePoint(align, 100); // alignment weight is 100
                    boolean tooClose = (distance < SeparationRange);
                    double weight = 200.0;
                    if (tooClose) {
                        weight *= Math.pow(1 - (double) distance / SeparationRange, 2);
                    }
                    else {
                        weight *= - Math.pow((double)( distance - SeparationRange ) / ( DetectionRange - SeparationRange ), 2);
                    }
                    Point attract = sumPoints(otherLocation, -1.0, tortue.getLocation(), 1.0);
                    attract = normalisePoint(attract, weight); // weight is variable
                    Point dist = sumPoints(align, 1.0, attract, 1.0);
                    dist = normalisePoint(dist, 100); // final weight is 100
                    target = sumPoints(target, 1.0, dist, 1.0);
                }
            /*
             * If this bird is a predator, and the other bird is a normal bird
             * then there is again attraction, but the weight is fixed at 1.
             */
                else if ((tortue instanceof Predator) && (autresTortue.getClass().equals(Bird.class))) {
                    Point dist = sumPoints(tortue.getLocation(), -1.0, otherLocation, 1.0);
                    dist = normalisePoint(dist, 1000);
                    double weight = 1;
                    target = sumPoints(target, 1.0, dist, weight); // weight is variable
                }
            /*
             * If the other bird is food, then there is attraction, for both
             * birds and predators.
             */
                else if (autresTortue instanceof Food) {
                    Point dist = sumPoints(tortue.getLocation(), -1.0, otherLocation, 1.0);
                    dist = normalisePoint(dist, 1000);
                    double weight = 1;
                    target = sumPoints(target, 1.0, dist, weight); // weight is variable
                }
            /*
             * If the birds are a different color (or if the other bird is actually
             * an obstacle, the bird is repulsed with a force that is weighted
             * according to a distance square rule.
             */
                else {
                    Point dist = sumPoints(tortue.getLocation(), 1.0, otherLocation, -1.0);
                    dist = normalisePoint(dist, 1000);
                    double weight = Math.pow((1 - (double)distance/DetectionRange), 2);
                    target = sumPoints(target, 1.0, dist, weight); // weight is variable
                }
                numBirds++;
            }
        }
        // if no birds are close enough to detect, continue moving is same direction.
        if (numBirds == 0) {
            return tortue.getTheta();
        }
        else { // average target points and add to position
            target = sumPoints(tortue.getLocation(), 1.0, target, 1/(double)numBirds);
        }

        // Turn the target location into a direction in degrees
        int targetTheta = (int)(180/Math.PI * Math.atan2(tortue.getLocation().y - target.y, target.x - tortue.getLocation().x));
        // Make sure the angle is 0-360
        return (targetTheta + 360) % 360; // angle for Bird to steer towards
    }

    /**
     * Sometimes, two birds are closer together if you go off one edge of the map
     * and return on the other. This function will convert the "other point" into
     * a point that closest to the point p, even if it is off the map.
     *
     * @param  p The point to measure the distance to.
     * @param  otherPoint The point to measure the distance from.
     */
    public Point closestLocation(Point p, Point otherPoint) {
        int dX = Math.abs(otherPoint.x - p.x);
        int dY = Math.abs(otherPoint.y - p.y);
        int x = otherPoint.x;
        int y = otherPoint.y;

        // now see if the distance between birds is closer if going off one
        // side of the map and onto the other.
        if ( Math.abs(Tortue.WIDTH- otherPoint.x + p.x) < dX ) {
            dX = Tortue.WIDTH - otherPoint.x + p.x;
            x = otherPoint.x - Tortue.WIDTH;
        }
        if ( Math.abs(Tortue.WIDTH - p.x + otherPoint.x) < dX ) {
            dX = Tortue.WIDTH - p.x + otherPoint.x;
            x = otherPoint.x + Tortue.WIDTH;
        }

        if ( Math.abs(Tortue.HEIGHT - otherPoint.y + p.y) < dY ) {
            dY = Tortue.HEIGHT - otherPoint.y + p.y;
            y = otherPoint.y - Tortue.HEIGHT;
        }
        if ( Math.abs(Tortue.HEIGHT - p.y + otherPoint.y) < dY ) {
            dY = Tortue.HEIGHT - p.y + otherPoint.y;
            y = otherPoint.y + Tortue.HEIGHT;
        }

        return new Point( x, y );
    }

    /**
     * Normalize a point.
     *
     * @param  p The point to normalize.
     * @param  n The normalization value.
     */
    public Point normalisePoint(Point p, double n) {
        if (sizeOfPoint(p) == 0.0) {
            return p;
        }
        else {
            double weight = n / sizeOfPoint(p);
            return new Point((int)(p.x * weight), (int)(p.y * weight));
        }
    }

    /**
     * Distance from the top left of the map to a given point
     *
     * @param  p The point to measure the distance to.
     */
    public double sizeOfPoint(Point p) {
        return Math.sqrt(Math.pow(p.x, 2) + Math.pow(p.y, 2));
    }


    


}
