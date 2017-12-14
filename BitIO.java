////////////////////////////////////////////////////////////////////
//  File:         TestBitIO.java                                  //
//  Author:       Mike Simpson                                    //
//  Description:  BitInputFile and BitOuputFile classes           //
//                                                                //
////////////////////////////////////////////////////////////////////

import java.io.*;

class BitIO {

  static public void main(String[] args) throws IOException {

    //--------------------------------------------------------------
    //            Write bits to the output file
    //--------------------------------------------------------------
    // ASCII values:
    // 41 74 6C 61    Atla
    // 74 6C OA OA    tl..
    //
    // Bit values:
    // 76543 2107 6543210 765432 10
    // 01000 0010 1110100 011011 00
    //   8     2     116     27
    //
    // 765432107654 3210 76543210 765432107654321 0
    // 011000010111 0100 01100110 000001010000101 0
    //        1559    4      108          1285
    // -----------------open the file-------------------------------
    BitOutputFile bout = new BitOutputFile("ioTest.txt");

    // -----------------write the bits------------------------------
    bout.write(8,5);
    bout.write(2,4);
    bout.write(116,7);
    bout.write(27,6);
    bout.flush();            // flush should pad 2 zeros into the 6
    bout.write(1559,12);     // bits in the buffer...
    bout.write(4,4);
    bout.write(108,8);
    bout.write(1285,15);
    //------------------close the file------------------------------
    bout.close();            // should flush the bit buffer first



    //--------------------------------------------------------------
    //                  read bits back from file
    //--------------------------------------------------------------
    //------------------open the file-------------------------------
    BitInputFile bin = new BitInputFile("ioTest.txt");

    //------------------read bits back in---------------------------
    System.out.println("Reading bits from file");
    System.out.println(bin.read(5));
    System.out.println(bin.read(4));
    System.out.println(bin.read(7));
    System.out.println(bin.read(6));
    System.out.println(bin.read(2));
    System.out.println(bin.read(12));
    System.out.println(bin.read(4));
    System.out.println(bin.read(8));
    System.out.println(bin.read(15));
    System.out.println("End of file test returns " + bin.eof());
    System.out.println(bin.read(1));
    System.out.println("End of file test returns " + bin.eof());
  }
}

