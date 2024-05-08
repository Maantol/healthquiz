package com.healthquiz;

/**
 * The GameScore class represents the score of a game in terms of sleeping,
 * nutrition, and exercise points.
 * It provides methods to set and retrieve the points for each category, as well
 * as check if the user is healthy.
 */
public class GameScore {

    private static double sleepingPoints = 0.0;
    private static double nutritionPoints = 0.0;
    private static double exercisePoints = 0.0;

    private GameScore() {
    }

    /**
     * Sets the points for sleeping.
     * 
     * @param sleepingPoints the points for sleeping
     */
    public static void setSleepingPoints(double sleepingPoints) {
        GameScore.sleepingPoints = sleepingPoints;
    }

    /**
     * Sets the points for nutrition.
     * 
     * @param nutritionPoints the points for nutrition
     */
    public static void setNutritionPoints(double nutritionPoints) {
        GameScore.nutritionPoints = nutritionPoints;
    }

    /**
     * Sets the points for exercise.
     * 
     * @param exercisePoints the points for exercise
     */
    public static void setExercisePoints(double exercisePoints) {
        GameScore.exercisePoints = exercisePoints;
    }

    /**
     * Resets all the points for sleeping, nutrition, and exercise to zero.
     * Currently not used in the application, for future development if
     * added possibility to play the game multiple times.
     */
    public static void resetAllPoints() {
        GameScore.sleepingPoints = 0.0;
        GameScore.nutritionPoints = 0.0;
        GameScore.exercisePoints = 0.0;
    }

    /**
     * Checks if the user is healthy based on the points for sleeping, nutrition,
     * and exercise.
     * 
     * @return true if the user is healthy, false otherwise
     */
    public static boolean isUserHealthy() {
        return sleepingPoints >= 6 && nutritionPoints >= 4 && exercisePoints >= 4;
    }

    /**
     * Gets the points for sleeping.
     * 
     * @return the points for sleeping
     */
    public static double getSleepingPoints() {
        return sleepingPoints;
    }

    /**
     * Gets the points for nutrition.
     * 
     * @return the points for nutrition
     */
    public static double getNutritionPoints() {
        return nutritionPoints;
    }

    /**
     * Gets the points for exercise.
     * 
     * @return the points for exercise
     */
    public static double getExercisePoints() {
        return exercisePoints;
    }

}