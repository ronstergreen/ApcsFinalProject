
public enum Square {
    PERIOD('.'), 
    COMMA(','),
    SEMICOLON(';'), 
    A('A'), 
    HASHTAG('#'), 
    P('P'), 
    C('C'),
    M('M'),
    PLAYER('@');
    private final char character;
    Square(char c) {
        character = c;
    }
    char character() {
        return character;
    }
}
