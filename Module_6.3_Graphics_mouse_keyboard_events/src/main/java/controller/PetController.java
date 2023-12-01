package controller;

import model.Pet;
import view.PetView;

public class PetController {
    private PetView view;
    private Pet pet;
    private final double originalSpeed = 3;

    public PetController(PetView view) {
        this.view = view;
    }

    public void initializePet() {
        pet = new Pet(200, 200, originalSpeed); // Initial position and speed
        updateView();
    }

    public void handleMouseMove(double mouseX, double mouseY) {
        double dx = mouseX - pet.getX();
        double dy = mouseY - pet.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);

        if (distance > pet.getSpeed()) {
            double ratio = pet.getSpeed() / distance;
            double moveX = ratio * dx;
            double moveY = ratio * dy;

            pet.setX(pet.getX() + moveX);
            pet.setY(pet.getY() + moveY);
        } else {
            pet.setX(mouseX);
            pet.setY(mouseY);
        }

        updateView();
    }

    public void handleMouseExit() {
        // Stop the pet immediately
        pet.setSpeed(0);
    }

    public void handleMouseEnter() {
        // Reset the pet's speed to its original speed
        pet.setSpeed(originalSpeed);
    }

    private void updateView() {
        view.drawPet(pet.getX(), pet.getY());
    }
}
