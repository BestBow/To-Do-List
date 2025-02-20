class Task {
    private int id;
    private String description;
    private boolean isCompleted;

    public Task(int id, String description, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String toFileFormat() {
        return id + "," + description + "," + isCompleted;
    }

    public static Task fromFileFormat(String line) {
        String[] parts = line.split(",");
        return new Task(Integer.parseInt(parts[0]), parts[1], Boolean.parseBoolean(parts[2]));
    }

    public void displayTask() {
        String status = isCompleted ? "[Completed]" : "[Pending]";
        System.out.println(id + ". " + description + " " + status);
    }
}