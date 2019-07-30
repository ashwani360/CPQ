package Driver;

	import java.io.*;
	import java.awt.Point;
	import java.util.HashMap;
	import java.util.Scanner;
	 
	public class CSV {
	 
	    private HashMap<Point, String> _map = new HashMap<Point, String>();
	    private int _cols;
	    private int _rows;
	 
	    public void open(File file) throws FileNotFoundException, IOException {
	        open(file, ',');
	    }
	 
	    public void open(File file, char delimiter)
	            throws FileNotFoundException, IOException {
	        Scanner scanner = new Scanner(file);
	        scanner.useDelimiter(Character.toString(delimiter));
	 
	        clear();
	 
	        while(scanner.hasNextLine()) {
	            String[] values = scanner.nextLine().split(Character.toString(delimiter));
	 
	            int col = 0;
	            for ( String value: values ) {
	                _map.put(new Point(col, _rows), value);
	                _cols = Math.max(_cols, ++col);
	            }
	            _rows++;
	        }
	        scanner.close();
	    }
	 
	    public void save(File file) throws IOException {
	        save(file, ',');
	    }
	 
	    public void save(File file, char delimiter) throws IOException {
	        FileWriter fw = new FileWriter(file);
	        BufferedWriter bw = new BufferedWriter(fw);
	 
	        for (int row = 0; row < _rows; row++) {
	            for (int col = 0; col < _cols; col++) {
	                Point key = new Point(col, row);
	                if (_map.containsKey(key)) {
	                    bw.write(_map.get(key));
	                }
	 
	                if ((col + 1) < _cols) {
	                    bw.write(delimiter);
	                }
	            }
	            bw.newLine();
	        }
	        bw.flush();
	        bw.close();
	    }
	 
	    public String get(int col, int row) {
	        String val = "";
	        Point key = new Point(col, row);
	        if (_map.containsKey(key)) {
	            val = _map.get(key);
	        }
	        return val;
	    }
	 
	    public void Set(int col, int row, String value) {
	        _map.put(new Point(col, row), value);
	        _cols = Math.max(_cols, col+1);
	        _rows = Math.max(_rows, row+1);
	    }
	 
	    public void clear() {
	        _map.clear();
	        _cols = 0;
	        _rows = 0;
	    }
	 
	    public int rows() {
	        return _rows;
	    }
	 
	    public int cols() {
	        return _cols;
	    }
	    
	    public static void createfile( String acv,String tcv,String arr,String igmad, String filename)
	    {
	    	 try 
		        {
		            CSV csv = new CSV();	 
		            csv.open(new File("src\\Data\\DealPricingCSVupload.csv"));
		           
//		            csv.Set(1, 13, "\""+acv+"\"");
//		            csv.Set(2, 13, "");
//		            csv.Set(1, 14, "\""+tcv+"\"");
//		            csv.Set(2, 14, "");
//		            csv.Set(1, 15, "\""+arr+"\"");
//		            csv.Set(2, 15, "");
//		            csv.Set(1, 22, igmad);
		            csv.Set(1, 13, acv);
		            csv.Set(2, 13, "");
		            csv.Set(1, 14, tcv);
		            csv.Set(2, 14, "");
		            csv.Set(1, 15, arr);
		            csv.Set(2, 15, "");
		            csv.Set(1, 22, igmad);
		           
		            csv.save(new File( "src\\Data\\"+filename+".csv"));
		            System.out.println("The file is successfully updated :- "+csv.get(1, 14)) ;
		        } 
		        catch (Exception e) 
		        {
		        	System.out.println("The file is already opened : "+e.getMessage());
		        }
	    	
	    }
	 
	    public static void main(String[] args) 
	    {
	    	createfile( "14.817,60","14.817,60","12,801.60","28","Test");
	    }
	}


