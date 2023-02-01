import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Maze {
	class Cell {
		private int row;
		private int col;
		private Cell from;

		public Cell(int row, int col, Cell from) {
			this.row = row;
			this.col = col;
			this.from = from;
		}
	}

	char[][] maze = { { '#', '#', '#', '#', 'B', '#', '#', '#', '#', '#', '#', '#' },
			{ '#', '#', '#', '#', '.', '.', '.', '.', '#', '#', '#', '#' },
			{ '#', '#', '#', '#', '.', '#', '#', '#', '#', '.', '.', '#' },
			{ '#', '.', '.', '.', '.', '#', '#', '#', '#', '#', '.', '#' },
			{ '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#' },
			{ '#', '.', '#', '#', '#', '#', '#', '.', '#', '#', '.', '#' },
			{ '#', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.', '#' },
			{ '#', '.', '#', '#', '.', '#', '#', '#', '.', '#', '.', '#' },
			{ '#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '#' },
			{ '#', '#', '.', '#', '.', '#', '#', '#', '.', '#', '.', 'A' },
			{ '#', '#', '.', '#', '#', '#', '.', '.', '.', '#', '#', '#' },
			{ '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

	public void show() {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++)
				System.out.print(" " + maze[i][j]);
			System.out.println();
		}
	}

	// ����from���������ڵĿ�Ⱦɫ�ڵ�Ⱦɫ����Ⱦɫ�ڵ���� dest
	// һ�����ֳ��ڽ���Ⱦɫ���򷵻ص�ǰ�ġ�����Դ���ڵ�
	public Cell colorCell(Set<Cell> from, Set<Cell> dest)
	{
		Iterator<Cell> it = from.iterator();
		while(it.hasNext())
		{
			Cell a = it.next();
			Cell[] c = new Cell[4];
			c[0] = new Cell(a.row-1, a.col, a);
			c[1] = new Cell(a.row, a.col-1, a);
			c[2] = new Cell(a.row+1, a.col, a);
			c[3] = new Cell(a.row, a.col+1, a);
						
			for(int i=0; i<4; i++)
			{
				if(c[i].row < 0 || c[i].row >= maze.length) continue;
				if(c[i].col < 0 || c[i].col >= maze[0].length) continue;
				
				char x = maze[c[i].row][c[i].col];
				if(x=='B') return a;
				if(x=='.') 
				{
					maze[c[i].row][c[i].col] = '?';
					dest.add(c[i]);
				}
			}
		}
		return null;
	}

	public void resolve()
	{
		Set<Cell> set = new HashSet<Cell>();
		set.add(new Cell(9,11,null));
		
		for(;;)
		{
			Set<Cell> set1 = new HashSet<Cell>();
			Cell a = colorCell(set, set1);
			if(a!=null)
			{
				System.out.println("�ҵ��⣡");
				while(a!=null)
				{
					maze[a.row][a.col] = '+';
					a = a.from;
				}
				break;
			}
			if(set1.isEmpty())
			{
				System.out.println("�޽⣡");
				break;
			}
			set = set1;
		}		
	}

	public static void main(String[] args) {
		Maze m = new Maze();
		m.show();
		m.resolve();
		m.show();
	}
}