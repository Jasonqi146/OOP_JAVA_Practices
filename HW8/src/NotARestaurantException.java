class NotARestaurantException extends RuntimeException {
    NotARestaurantException() {
        super("That is not a restaurant we know!");
    }
}