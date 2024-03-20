export interface ClothingResponse {
    clothing: Cloth[]
}

export interface Cloth {
    id: number;
    name: string;
    size: string;
    color: string;
    status: string;
    created_timestamp: Date;
    updated_timestamp: Date;
}
