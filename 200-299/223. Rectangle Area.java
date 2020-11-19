// 1. calculate area for rec1 and area for rec2
// 2. calculate overlap area if it exists
// 3. sum up the area of two recs and minus overlaop area

class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (D - B) * (C - A);
        int a2 = (H - F) * (G - E);
        int overlap = 0;
        
        boolean lap1 = G > C && !(F > D || H < B || E > C);
        boolean lap2 = G <= C && !(B > H || D < F || A > G);
        if (lap1 || lap2) {
            overlap = (Math.min(C,G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(B,F));
        }
        return a1 + a2 - overlap;
    }
}

// better in check the existence of overlap area
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a1 = (D - B) * (C - A);
        int a2 = (H - F) * (G - E);
        int overlap = 0;
        
        if (Math.max(A,E) < Math.min(C,G) && Math.max(B,F) < Math.min(D,H)) {
            overlap = (Math.min(C,G) - Math.max(A,E)) * (Math.min(D,H) - Math.max(B,F));
        }
        return a1 + a2 - overlap;
    }
}
