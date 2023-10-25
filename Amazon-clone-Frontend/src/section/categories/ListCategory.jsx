import { itemCategory } from "../../constant";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Typography from "@mui/material/Typography";
import { CardActionArea } from "@mui/material";

const ListCategory = () => {
  return (
    <div className="category-list">
      {itemCategory.map((item) => (
        <Card sx={{ width: 250, marginBottom: "2rem" }} key={item.alt}>
          <CardActionArea>
            <CardMedia
              component="img"
              height="140"
              image={item.src}
              alt="green iguana"
            />
            <CardContent>
              <Typography variant="h5" component="div" textAlign="center">
                {item.title}
              </Typography>
            </CardContent>
          </CardActionArea>
        </Card>
      ))}
    </div>
  );
};

export default ListCategory;
