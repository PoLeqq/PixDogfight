package pl.poleq.pixdogfight.entity.plane;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import lombok.Getter;
import lombok.Setter;
import pl.poleq.pixdogfight.entity.DestroyableEntity;

@Getter
@Setter
public class Plane extends DestroyableEntity {
    private final float MAX_SPEED;
    private final float MAX_THRUST;

//    private final float MAX_OVERLOAD;

    /**
     * Throttle set by player
     */
    private int throttleTarget;
    /**
     * Throttle that actual plane has
     */
    private float throttle;
    private float speed;
    private PlaneEquipment equipment;
    private float weight;
//    private float thrust;
    private float dragCoefficient;
    private float wingArea;
    private float liftCoefficient;

    private float throttleChangeSpeed;

    public Plane(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp, float MAX_SPEED, float MAX_THRUST, float weight, PlaneEquipment equipment, float dragCoefficient, float wingArea, float liftCoefficient) {
        super(texture, location, MAX_HP, hp);
        this.MAX_SPEED = MAX_SPEED;
        this.speed = 0; // Start at zero speed
        this.MAX_THRUST = MAX_THRUST;
        this.weight = weight;
        this.throttleTarget = 100; // Full throttle initially
        this.equipment = equipment;
        this.dragCoefficient = dragCoefficient;
        this.wingArea = wingArea;
        this.liftCoefficient = liftCoefficient;

        this.throttleChangeSpeed = 0.001f;
    }

//    public Plane(TextureAtlas.AtlasRegion texture, Vector2 location, int MAX_HP, int hp, float MAX_SPEED, float MAX_THRUST, float weight, PlaneEquipment equipment, float dragCoefficient) {
//        super(texture, location, MAX_HP, hp);
//        this.MAX_SPEED = MAX_SPEED;
//        this.speed = MAX_SPEED;
//        this.MAX_THRUST = MAX_THRUST;
//        this.weight = weight;
//        this.throttle = 100;
//        this.equipment = equipment;
//        this.dragCoefficient = dragCoefficient;
//    }

    public void changeThrottle(int value) {
        this.throttleTarget += value;
        if(this.throttleTarget > 100)
            this.throttleTarget = 100;
        if(this.throttleTarget < 0)
            this.throttleTarget = 0;
    }

    /**
     * Returns velocity for x-axis and y-axis
     * @return vector
     */
    public Vector2 getAxisVelocity() {
//        rotation in radians
        float radian = (float) Math.toRadians(getLocation().getRotation());

        float Vx = (float) Math.cos(radian) * getSpeed();
        float Vy = (float) Math.sin(radian) * getSpeed();

        return new Vector2(Vx, Vy);
    }

    public float getThrust() {
        return throttleTarget/100f * MAX_THRUST;
    }

    public float getDragForce() {
        return dragCoefficient * speed * speed;
    }

    public Vector2 getAxisThrust() {
        float rad = (float) Math.toRadians(getLocation().getRotation());

//        System.out.println("thrust: "+getThrust());
//        System.out.println("cos("+rad+"): "+Math.cos(rad));


        float thrustX = (float) (getThrust() * Math.cos(rad));
        float thrustY = (float) (getThrust() * Math.sin(rad));

        return new Vector2(thrustX, thrustY);
    }

//    public Vector2 getDrag() {
//        float drag = dragCoefficient * speed * speed;
//        float dragX = (float) (-drag * Math.cos(getLocation().getRotation()));
//        float dragY = (float) (-drag * Math.sin(getLocation().getRotation()));
//
//        return new Vector2(dragX, dragY);
//    }

//    public float getLift() {
//   // Adjust based on gameplay needs
////        double speed = Math.sqrt(speedX * speedX + speedY * speedY); // Magnitude of the current speed
//
//        // Calculate lift force based on speed
//        return dragCoefficient * getSpeed() * getSpeed();
//    }

    /**
     *
     * @return
     */
    public float getLift() {
//        L = (1/2) d v2 s CL
//        L = Lift, which must equal the airplane's weight in pounds
//        d = density of the air. This will change due to altitude. These values can be found in a I.C.A.O. Standard Atmosphere Table.
//        v = velocity of an aircraft expressed in feet per second
//        s = the wing area of an aircraft in square feet
//        CL = Coefficient of lift , which is determined by the type of airfoil and angle of attack.
//        The angle of attack and CL are related and can be found using a Velocity Relationship Curve Graph


        double density = 1;
        double wingArea = 5;
        float wingCoefficient = 3;

        return (float) (density/2 * getSpeed() * getSpeed() * wingArea * wingCoefficient);

//        double speed = Math.sqrt(speedX * speedX + speedY * speedY); // Magnitude of the current speed

        // Calculate lift force based on speed
//        return dragCoefficient * getSpeed() * getSpeed();
    }

    /**
     * Get acceleration of plane
     * @return acceleration value
     */
    public float getAcceleration() {
        return getThrust()/weight;
    }


    public Vector2 getVelocity(float gravity) {
        Vector2 thrust = getAxisThrust();

        float lift = getLift();

        float velocityX = thrust.x;
//        float velocityY = thrust.y - (gravity*weight) + lift;
//        float velocityY = thrust.y - (gravity*weight) + lift;
        float velocityY = thrust.y;

        return new Vector2(velocityX, velocityY);



//        Vector2 thrust = getThrust();
//        Vector2 drag = getDrag();
////        float accelerationX = thrust.x + drag.x + lift.x;
//        float accelerationX = thrust.x + drag.x;
////        float accelerationY = thrust.x + drag.x + lift.x - gravity;
//        float accelerationY = thrust.y + drag.y + getLift() - gravity;
//
//        System.out.println("accX: "+accelerationX);
//        System.out.println("accY: "+accelerationY);
//        return new Vector2(accelerationX, accelerationY);
    }



//    /**
//     * Updates plane position based on speed, rotation etc.
//     * @param delta delta time
//     */
//    public void updatePosition(float delta, float gravity) {
////        Vector2 vel = getAxisVelocity();
////        getLocation().addVector(vel.x * delta, vel.y * delta);
//
//        Vector2 vel = getVelocity(gravity);
//
////        calculate only if values are different
//        if(throttle != throttleTarget) {
//            float deltaThrottle = throttleTarget - throttle;
//
//            System.out.println("Delta throttle: "+deltaThrottle+"   ("+throttleTarget+") - "+"("+throttle+")");
//            throttle = throttle + deltaThrottle * throttleChangeSpeed * delta;
//
//            System.out.println("Throttle: "+throttle);
//        }
//
////        System.out.println("Veloity: ");
////        System.out.println(vel.x);
////        System.out.println(vel.y);
//
//        getLocation().addVector(vel.x * delta, vel.y * delta);
//
//
//    }
    public void updatePosition(float delta, float gravity) {
        // Calculate thrust and drag forces
        float thrustForce = getThrust();
        float dragForce = getDragForce();

        // Calculate net force (thrust - drag)
        float netForce = thrustForce - dragForce;

        // Acceleration is net force divided by weight
        float acceleration = netForce / weight;

        // Increment speed based on acceleration and time delta
        speed += acceleration * delta;

        // Cap speed to MAX_SPEED
        if (speed > MAX_SPEED) {
            speed = MAX_SPEED;
        }

        // Calculate velocity components based on speed and plane rotation
        float radian = (float) Math.toRadians(getLocation().getRotation());
        float velocityX = (float) (Math.cos(radian) * speed);
        float velocityY = (float) (Math.sin(radian) * speed);

        // Update position based on calculated velocity
        getLocation().addVector(velocityX * delta, velocityY * delta);

        // Smoothly adjust throttle if necessary
        if (throttle != throttleTarget) {
            float deltaThrottle = throttleTarget - throttle;
            throttle += deltaThrottle * throttleChangeSpeed * delta;
        }
    }

    public Vector2 getTailLocation() {
//        O - middle of entity
//        b(Ox-x, Oy-y)

        float rad = (float) Math.toRadians(getLocation().getRotation());

        float x = (float) (Math.sin(rad)*2);
        float y = (float) (Math.cos(rad)*2);

        return new Vector2(getLocation().getX()-x, getLocation().getY()-y);
    }

}
