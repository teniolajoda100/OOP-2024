//C22419214
package ie.tudublin;
import processing.core.PApplet;

public class Life extends PApplet {
    
    LifeBoard lifeBoard;
    

    public void setup()
    {
        lifeBoard = new LifeBoard(50, 50, this);
        lifeBoard.randomise();
        colorMode(HSB);
    }

    public void settings()
    {
        size(600, 600);
    }

    public void draw()
    {
        background(0); // black background
        lifeBoard.update(); // the state of the board
        lifeBoard.render(); // rendering the board
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