package ie.tudublin;
import processing.core.PApplet;

public class Life extends PApplet {
    
    LifeBoard lifeBoard;
    boolean isPaused = false; //variable to track the pause state
    
    public void setup()
    {
        lifeBoard = new LifeBoard(50, 50, this);
        lifeBoard.randomise();
        colorMode(HSB);
        size(600, 600);
        
    }
    public void keyPressed() {
        if (key == ' ') { // Toggle pause and resume
            isPaused = !isPaused;
        } else if (key == '1') { // Randomize the board
            lifeBoard.randomise();
        } else if (key == '2') { // Clear the board
            lifeBoard.clear();
        } else if (key == '3') { // Draw a cross shape
            lifeBoard.drawCross();
        }
    }

     public void settings()
    {
        size(600, 600);
    }

    public void draw()
    {
        if (!isPaused) { // if not paused
            background(0); // the state of the board
            lifeBoard.update();
        }
        lifeBoard.render();
        if(isPaused) {
            fill(0); // Set fill color to black
            rect(0, 0, width, height); // Draw a black rectangle over the entire screen to indicate paused state
            fill(255); // Set fill color to white for text
            textSize(32); // Set text size
            textAlign(CENTER, CENTER); // Align text to be centered
            text("Paused", width / 2, height / 2); // Display 'Paused' text in the center of the screen
        }
    }
    class LifeBoard {
        private int cols, rows;
        private boolean[][] board;
        private PApplet p;
    
        public LifeBoard(int cols, int rows, PApplet p) {
            this.cols = cols;
            this.rows = rows;
            this.p = p;
            board = new boolean[cols][rows];
        }
    
        public void randomise() {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    board[i][j] = p.random(1) < 0.5;
                }
            }
        }
    
        public void update() {
            boolean[][] newBoard = new boolean[cols][rows];
    
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    int liveNeighbors = countLiveNeighbors(i, j);
    
                    if (board[i][j]) {
                        newBoard[i][j] = liveNeighbors == 2 || liveNeighbors == 3;
                    } else {
                        newBoard[i][j] = liveNeighbors == 3;
                    }
                }
            }
    
            board = newBoard;
        }
    
        public void render() {
            p.stroke(0);
            float cellWidth = p.width / (float) cols;
            float cellHeight = p.height / (float) rows;
    
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    if (board[i][j]) {
                        p.fill(255); 
                    } else {
                        p.fill(0);
                    }
                    p.rect(i * cellWidth, j * cellHeight, cellWidth / 2, cellHeight);
                }
            }
        }
        public void clear() {
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    board[i][j] = false; // clearing the board by setting all cells to dead
                }
            }
        }
        public void drawCross() {
            int centerCol = cols / 2;
            int centerRow = rows / 2;
    
            // drawingine of the cross
            for (int i = -3; i <= 3; i++) {
                int row = centerRow + i;
                if (row >= 0 && row < rows) {
                    board[centerCol][row] = true;
                }
            }
    
            // drawing line of the cross
            for (int i = -3; i <= 3; i++) {
                int col = centerCol + i;
                if (col >= 0 && col < cols) {
                    board[col][centerRow] = true;
                }
            }
        }
    
    
        private int countLiveNeighbors(int x, int y) {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (!(i == 0 && j == 0)) {
                        int col = (x + i + cols) % cols;
                        int row = (y + j + rows) % rows;
                        count += board[col][row] ? 1 : 0;
                    }
                }
            }
            return count;
        }
    }
    
    
}